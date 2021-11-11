package org.experimentalplayers.hubapi.repositories;

import org.experimentalplayers.hubapi.models.Bot;
import org.experimentalplayers.hubapi.models.BotInput;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BotInputRepository extends JpaRepository<BotInput, UUID> {

    Optional<BotInput> findAllByName(String codename);

}
