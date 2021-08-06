package org.experimentalplayers.hubapi.repositories;

import org.experimentalplayers.hubapi.models.ApplicationModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ApplicationRepository extends CrudRepository<ApplicationModel, UUID> {

	Optional<ApplicationModel> findByNameShort(String shortName);

}
