package org.experimentalplayers.hubapi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.config.InputTypeMappings;
import org.experimentalplayers.hubapi.exceptions.NotFoundException;
import org.experimentalplayers.hubapi.models.InputType;
import org.experimentalplayers.hubapi.services.InputTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <h2>Application sub-API</h2>
 * <p>
 * The REST controller that listens for every {@link InputType Project} query.
 * <br><br>
 * This controller listens on {@link InputTypeMappings#ROOT this} path,
 * so the endpoint for all mapped methods will be /{@link InputTypeMappings#ROOT PROJECT_ROOT}/METHOD_MAPPING (with no trailing slash).
 * </p>
 */
@Slf4j
@RestController
@RequestMapping(InputTypeMappings.ROOT)
public class InputTypeController extends BaseController{

	@Autowired
	InputTypeService inputTypeService;

	@GetMapping(InputTypeMappings.FIND_ALL)
	public HttpEntity<?> findAll(@RequestParam(defaultValue = "1") Integer page,
								 @RequestParam(defaultValue = "10") Integer limit) {

		log.info("Begin findAll()...");

		Page<InputType> inputTypePage = inputTypeService.findAll(page,limit);

		log.info(inputTypePage.toString());

		log.info("End findAll()...");
		return new HttpEntity<>(inputTypePage);

	}

	@GetMapping(InputTypeMappings.FIND_BY_DESCRIPTION)
	public HttpEntity<?> findByName(@PathVariable String description) throws NotFoundException {

		log.info("Begin findByName()...");

		InputType inputType = inputTypeService.findByDescription(description);

		log.info("End findByName()...");
		return new HttpEntity<>(inputType);

	}

}
