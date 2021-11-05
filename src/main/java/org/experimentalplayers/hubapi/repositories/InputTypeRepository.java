package org.experimentalplayers.hubapi.repositories;

import org.experimentalplayers.hubapi.models.InputType;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface InputTypeRepository extends PagingAndSortingRepository<InputType, UUID> {

	Optional<InputType> findByCodename(String shortName);

}
