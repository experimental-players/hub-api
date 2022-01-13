package org.experimentalplayers.hubapi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.config.ProjectMappings;
import org.experimentalplayers.hubapi.exceptions.NotFoundException;
import org.experimentalplayers.hubapi.models.Project;
import org.experimentalplayers.hubapi.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * <h2>Application sub-API</h2>
 * <p>
 * The REST controller that listens for every {@link Project Project} query.
 * <br><br>
 * This controller listens on {@link ProjectMappings#ROOT this} path,
 * so the endpoint for all mapped methods will be /{@link ProjectMappings#ROOT PROJECT_ROOT}/METHOD_MAPPING (with no trailing slash).
 * </p>
 */
@Slf4j
@RestController
@RequestMapping(ProjectMappings.ROOT)
public class ProjectController extends BaseController {

	@Autowired
	private ProjectService projectService;

	@GetMapping(ProjectMappings.FIND_ALL)
	public HttpEntity<?> findAll(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer limit, @RequestParam(required = false) UUID categoryId) {

		log.debug("Begin findAll()...");

		Page<Project> projectPage;

		if(categoryId == null)
			projectPage = projectService.findAll(page, limit);
		else
			projectPage = projectService.findAllByCategory(categoryId, page, limit);

		log.debug(projectPage.toString());

		log.debug("End findAll()...");
		return new HttpEntity<>(projectPage);

	}

	@GetMapping(ProjectMappings.FIND_BY_NAME)
	public HttpEntity<?> findByName(@PathVariable String name) throws NotFoundException {

		log.info("Begin findByName()...");

		Project project = projectService.findByName(name);

		log.info("End findByName()...");
		return new HttpEntity<>(project);

	}

}