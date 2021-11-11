package org.experimentalplayers.hubapi.controllers;

import Utils.Status;
import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.config.CategoryMappings;
import org.experimentalplayers.hubapi.exceptions.NotFoundException;
import org.experimentalplayers.hubapi.models.Category;
import org.experimentalplayers.hubapi.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * <h2>Application sub-API</h2>
 * <p>
 * The REST controller that listens for every {@link Category Application} query.
 * <br><br>
 * This controller listens on {@link CategoryMappings#ROOT this} path,
 * so the endpoint for all mapped methods will be /{@link CategoryMappings#ROOT APPLICATION_ROOT}/METHOD_MAPPING (with no trailing slash).
 * </p>
 */
@Slf4j
@RestController()
@RequestMapping(CategoryMappings.ROOT)
public class CategoryController {

	@Autowired
	CategoryService categoryService;

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

    @GetMapping(CategoryMappings.FIND_ALL)
    public HttpEntity<?> findAll(@RequestParam(defaultValue = "1") Integer page,
                                               @RequestParam(defaultValue = "10") Integer limit) {

        log.info("Begin findAll()...");

		Page<Category> categoryPage = categoryService.findAll(page,limit);

        log.info(categoryPage.toString());

        log.info("End findAll()...");
		HttpEntity<?> httpEntity = new HttpEntity<>(categoryPage);
		return httpEntity;

    }


    @GetMapping(CategoryMappings.FIND_BY_NAME)
    public HttpEntity<?> findByName(@PathVariable String name) throws NotFoundException {

        log.info("Begin findByName()...");

       Category category = categoryService.findByName(name);

        log.info("End findByName()...");
		HttpEntity<?> httpEntity = new HttpEntity<>(category);
		return httpEntity;

    }

}