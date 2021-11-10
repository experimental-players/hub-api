package org.experimentalplayers.hubapi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.config.CategoryMappings;
import org.experimentalplayers.hubapi.exceptions.NotFoundException;
import org.experimentalplayers.hubapi.models.Category;
import org.experimentalplayers.hubapi.repositories.CategoryRepository;
import org.experimentalplayers.hubapi.responses.CollectionResponse;
import org.experimentalplayers.hubapi.responses.CollectionResponse.CollectionResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping(CategoryMappings.ROOT)
public class CategoryController {

    @Autowired
    private CategoryRepository catRepo;

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
    public CollectionResponse findAll(@RequestParam(defaultValue = "1") int page,
                                      @RequestParam(defaultValue = "10") int limit) {

        log.info("Begin findAll()...");

        // TODO: PAGEABLE

        CollectionResponseBuilder responseBuilder = CollectionResponse
                .builder()
                .limit(limit)
                .page(page);

        for(Category category : catRepo.findAll())
            responseBuilder.result(category);

        System.out.println(responseBuilder.toString());

        log.info("End findAll()...");
        return responseBuilder.build();

    }

    @GetMapping(CategoryMappings.FIND_BY_NAME)
    public Category findByName(@PathVariable String name) throws NotFoundException {

        log.info("Begin findByName()...");

        Optional<Category> opt = catRepo.findAllByCodename(name);

        if(!opt.isPresent())
            throw new NotFoundException();

        log.info("End findByName()...");
        return opt.get();

    }

}