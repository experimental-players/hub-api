package org.experimentalplayers.hubapi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.config.BotMappings;
import org.experimentalplayers.hubapi.exceptions.NotFoundException;
import org.experimentalplayers.hubapi.models.Bot;
import org.experimentalplayers.hubapi.repositories.BotRepository;
import org.experimentalplayers.hubapi.responses.CollectionResponse;
import org.experimentalplayers.hubapi.responses.CollectionResponse.CollectionResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * <h2>Application sub-API</h2>
 * <p>
 * The REST controller that listens for every {@link Bot Application} query.
 * <br><br>
 * This controller listens on {@link BotMappings#ROOT this} path,
 * so the endpoint for all mapped methods will be /{@link BotMappings#ROOT APPLICATION_ROOT}/METHOD_MAPPING (with no trailing slash).
 * </p>
 */
@Slf4j
@RestController
@RequestMapping(BotMappings.ROOT)
public class BotController {

	@Autowired
	private BotRepository catRepo;

	/**
	 * Find all applications.
	 *
	 * <br>
	 * This endpoint only accepts GET requests, a 405 MethodNotAllowed response will be sent for other HTTP methods.
	 *
	 * @param page  Not implemented yet, the page number if there are more elements than limit
	 * @param limit Not implemented yet, the max elements to retrieve in a call
	 * @return An {@link Iterable} containing all the elements retrieved
	 */
	@GetMapping(BotMappings.FIND_ALL)
	public CollectionResponse findAll(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int limit) {

		PageRequest request = PageRequest.of(page, limit);

		CollectionResponseBuilder responseBuilder = CollectionResponse
				.builder()
				.limit(limit)
				.page(page);

		for(Bot category : catRepo.findAll(request))
			responseBuilder.result(category);

		System.out.println(responseBuilder.toString());

		return responseBuilder.build();

	}

	@GetMapping(BotMappings.FIND_BY_NAME)
	public Bot findByName(@PathVariable String name) throws NotFoundException {

		Optional<Bot> opt = catRepo.findAllByName(name);

		if(!opt.isPresent())
			throw new NotFoundException();

		return opt.get();

	}

}
