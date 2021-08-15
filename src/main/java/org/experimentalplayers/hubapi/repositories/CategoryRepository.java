package org.experimentalplayers.hubapi.repositories;

import org.experimentalplayers.hubapi.models.CategoryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryModel, UUID> {

	Optional<CategoryModel> findByCodename(String codename);

}
