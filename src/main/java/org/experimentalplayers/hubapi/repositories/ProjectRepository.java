package org.experimentalplayers.hubapi.repositories;

import org.experimentalplayers.hubapi.models.Project;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectRepository extends PagingAndSortingRepository<Project, UUID> {

	@NotNull Page<Project> findAll();

	Optional<Project> findAllByCodename(String shortName);

	List<Project> findAllByCategory_Id(UUID categoryId);

}
