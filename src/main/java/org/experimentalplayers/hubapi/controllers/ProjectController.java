package org.experimentalplayers.hubapi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.config.CategoryMappings;
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

/**
 * <h2>Application sub-API</h2>
 * <p>
 * The REST controller that listens for every {@link ProjectModel Project} query.
 * <br><br>
 * This controller listens on {@link ProjectMappings#ROOT this} path,
 * so the endpoint for all mapped methods will be /{@link ProjectMappings#ROOT PROJECT_ROOT}/METHOD_MAPPING (with no trailing slash).
 * </p>
 */
@Slf4j
@RestController
@RequestMapping(ProjectMappings.ROOT)
public class ProjectController {

	@Autowired
	private ProjectRepository projRepo;

	@GetMapping(CategoryMappings.FIND_ALL)
	public Iterable<ProjectModel> findAll() {

		return projRepo.findAll();

	}

	@GetMapping(CategoryMappings.FIND_BY_NAME)
	public ProjectModel findByName(@PathVariable String name) throws NotFoundException {

		Optional<ProjectModel> opt = projRepo.findByNameShort(name);

		if(!opt.isPresent())
			throw new NotFoundException();

		return opt.get();

	}

}
