package org.experimentalplayers.hubapi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.config.InputTypeMappings;
import org.experimentalplayers.hubapi.exceptions.NotFoundException;
import org.experimentalplayers.hubapi.models.InputType;
import org.experimentalplayers.hubapi.repositories.InputTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
public class InputTypeController {

	@Autowired
	private InputTypeRepository inputTypeRepository;

	@GetMapping(InputTypeMappings.FIND_ALL)
	public Iterable<InputType> findAll() {

		return inputTypeRepository.findAll();

	}

	@GetMapping(InputTypeMappings.FIND_BY_NAME)
	public InputType findByName(@PathVariable String name) throws NotFoundException {

		Optional<InputType> opt = inputTypeRepository.findAllByDescription(name);

		if(!opt.isPresent())
			throw new NotFoundException();

		return opt.get();

	}

}
