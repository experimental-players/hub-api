package org.experimentalplayers.hubapi.services;

import org.experimentalplayers.hubapi.models.Project;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface ProjectService {

	Page<Project> findAll(Integer page, Integer limit);

	Page<Project> findAllByCategory(UUID categoryId, Integer page, Integer limit);

	Project findByName(String name);

}
