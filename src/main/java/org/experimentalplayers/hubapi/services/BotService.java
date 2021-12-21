package org.experimentalplayers.hubapi.services;

import org.experimentalplayers.hubapi.models.Bot;
import org.springframework.data.domain.Page;

public interface BotService {

    Page<Bot> findAll(Integer page, Integer limit);

    Bot findByName(String name);


}
