package org.experimentalplayers.hubapi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.config.CategoryMappings;
import org.experimentalplayers.hubapi.exceptions.NotFoundException;
import org.experimentalplayers.hubapi.models.CategoryModel;
import org.experimentalplayers.hubapi.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * <h2>Application sub-API</h2>
 * <p>
 * The REST controller that listens for every {@link CategoryModel Application} query.
 * <br><br>
 * This controller listens on {@link CategoryMappings#ROOT this} path,
 * so the endpoint for all mapped methods will be /{@link CategoryMappings#ROOT APPLICATION_ROOT}/METHOD_MAPPING (with no trailing slash).
 * </p>
 */
@Slf4j
@RestController
@RequestMapping(CategoryMappings.ROOT)
public class CategoryController {

	@Autowired
	private CategoryRepository appRepo;

	/**
	 * Find all applications.
	 *
	 * <br>
	 * This endpoint only accepts GET requests, a 405 MethodNotAllowed response will be sent for other HTTP methods.
	 *
	 * @param page    Not implemented yet, the page number if there are more elements than maxSize
	 * @param maxSize Not implemented yet, the max elements to retrieve in a call
	 * @return An {@link Iterable} containing all the elements retrieved
	 */
	@GetMapping(CategoryMappings.FIND_ALL)
	public Iterable<CategoryModel> findAll(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int maxSize) {

		return appRepo.findAll();

	}

	@GetMapping(CategoryMappings.FIND_BY_NAME)
	public CategoryModel findByName(@PathVariable String name) throws NotFoundException {

		Optional<CategoryModel> opt = appRepo.findByNameShort(name);

		if(!opt.isPresent())
			throw new NotFoundException();

		return opt.get();

	}

}
