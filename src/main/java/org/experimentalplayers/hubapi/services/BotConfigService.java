package org.experimentalplayers.hubapi.services;

import org.experimentalplayers.hubapi.models.BotConfig;
import org.springframework.data.domain.Page;

public interface BotConfigService {

    Page<BotConfig> findAll(Integer page, Integer limit);

    BotConfig findByIdServer(Long idServer);

}
