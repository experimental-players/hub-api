package org.experimentalplayers.hubapi.repositories;

import org.experimentalplayers.hubapi.models.BotConfig;
import org.experimentalplayers.hubapi.models.BotInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BotConfigRepository extends JpaRepository<BotConfig, Long> {

    Optional<BotConfig> findAllByIdServer(Long idServer);

}
