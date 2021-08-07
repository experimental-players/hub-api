package org.experimentalplayers.hubapi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.config.ApplicationMappings;
import org.experimentalplayers.hubapi.config.ProjectMappings;
import org.experimentalplayers.hubapi.exceptions.NotFoundException;
import org.experimentalplayers.hubapi.models.ProjectModel;
import org.experimentalplayers.hubapi.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(ProjectMappings.ROOT)
public class ProjectController {

	@Autowired
	private ProjectRepository projRepo;

	@GetMapping(ApplicationMappings.FIND_ALL)
	public Iterable<ProjectModel> findAll() {

		return projRepo.findAll();

	}

	@GetMapping(ApplicationMappings.FIND_BY_NAME)
	public ProjectModel findByName(@PathVariable String name) {

		Optional<ProjectModel> opt = projRepo.findByNameShort(name);

		if(!opt.isPresent())
			throw new NotFoundException();

		return opt.get();

	}

}
