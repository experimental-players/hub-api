package org.experimentalplayers.hubapi.repositories;

import org.experimentalplayers.hubapi.models.Bot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BotRepository extends JpaRepository<Bot, UUID> {

	Optional<Bot> findAllByName(String codename);

}
