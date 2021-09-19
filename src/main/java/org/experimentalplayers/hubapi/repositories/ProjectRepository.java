package org.experimentalplayers.hubapi.repositories;

import org.experimentalplayers.hubapi.models.ProjectModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectRepository extends CrudRepository<ProjectModel, UUID> {

	Optional<ProjectModel> findByCodename(String shortName);

}
