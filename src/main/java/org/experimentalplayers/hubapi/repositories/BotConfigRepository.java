package org.experimentalplayers.hubapi.repositories;

import org.experimentalplayers.hubapi.models.BotConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BotConfigRepository extends JpaRepository<BotConfig, Long> {

    Optional<BotConfig> findAllByIdServer(Long idServer);

}
