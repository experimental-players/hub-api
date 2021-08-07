package org.experimentalplayers.hubapi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.config.ApplicationMappings;
import org.experimentalplayers.hubapi.exceptions.NotFoundException;
import org.experimentalplayers.hubapi.models.ApplicationModel;
import org.experimentalplayers.hubapi.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * <h2>Application sub-API</h2>
 * <p>
 * The REST controller that listens for every {@link ApplicationModel Application} query.
 * <br><br>
 * This controller listens on {@link ApplicationMappings#ROOT this} path,
 * so the endpoint for all mapped methods will be /{@link ApplicationMappings#ROOT APPLICATION_ROOT}/METHOD_MAPPING (with no trailing slash).
 * </p>
 */
@Slf4j
@RestController
@RequestMapping(ApplicationMappings.ROOT)
public class ApplicationController {

	@Autowired
	private ApplicationRepository appRepo;

	/**
	 * Find all applications.
	 *
	 * <br>
	 * This endpoint only accepts GET requests, a 405 MethodNotAllowed response will be sent for other HTTP methods.
	 *
	 * @param page    Not implemented yet, the page number if there are more elements than maxSize
	 * @param maxSize Not implemented yet, the max elements to retrieve in a call
	 * @return An {@link Iterable<ApplicationModel>} containing all the elements retrieved
	 */
	@GetMapping(ApplicationMappings.FIND_ALL)
	public Iterable<ApplicationModel> findAll(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int maxSize) {

		return appRepo.findAll();

	}

	@GetMapping(ApplicationMappings.FIND_BY_NAME)
	public ApplicationModel findByName(@PathVariable String name) {

		Optional<ApplicationModel> opt = appRepo.findByNameShort(name);

		if(!opt.isPresent())
			throw new NotFoundException();

		return opt.get();

	}

}
