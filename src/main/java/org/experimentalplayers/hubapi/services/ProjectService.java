package org.experimentalplayers.hubapi.services;

import org.experimentalplayers.hubapi.models.Project;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ProjectService {

	Page<Project> findAll(Integer page, Integer limit);

	Optional<Project> findByName(String name);

}
