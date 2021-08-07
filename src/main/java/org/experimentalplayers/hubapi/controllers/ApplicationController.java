package org.experimentalplayers.hubapi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.config.ApplicationMappings;
import org.experimentalplayers.hubapi.exceptions.NotFoundException;
import org.experimentalplayers.hubapi.models.ApplicationModel;
import org.experimentalplayers.hubapi.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(ApplicationMappings.ROOT)
public class ApplicationController {

	@Autowired
	private ApplicationRepository appRepo;

	@GetMapping(ApplicationMappings.FIND_ALL)
	public Iterable<ApplicationModel> findAll() {

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
