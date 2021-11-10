package org.experimentalplayers.hubapi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.config.CategoryMappings;
import org.experimentalplayers.hubapi.config.ProjectMappings;
import org.experimentalplayers.hubapi.models.Project;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import services.ProjectService;


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
public class ProjectController {


    private ProjectService projectService;

    @GetMapping(ProjectMappings.FIND_ALL)
    public HttpEntity<?> findAll(@RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "10") int limit) {

        log.info("Begin findAll()...");

        Page<Project> projects = projectService.findAll(page,limit);

        log.info("End findAll()...");
        HttpEntity<?> httpEntity = new HttpEntity<>(projects);
        return httpEntity;

    }
/*
    @GetMapping(CategoryMappings.FIND_BY_NAME)
    public Project findByName(@PathVariable String name) throws NotFoundException {

        Optional<Project> opt = projRepo.findByCodename(name);

        if(!opt.isPresent())
            throw new NotFoundException();

        return opt.get();

    }
*/
}