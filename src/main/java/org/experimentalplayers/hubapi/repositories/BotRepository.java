package org.experimentalplayers.hubapi.repositories;

import org.experimentalplayers.hubapi.models.Bot;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BotRepository extends PagingAndSortingRepository<Bot, UUID> {

	Optional<Bot> findAllByName(String codename);

}
