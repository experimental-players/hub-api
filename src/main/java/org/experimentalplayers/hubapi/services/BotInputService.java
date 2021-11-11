package org.experimentalplayers.hubapi.services;

import org.experimentalplayers.hubapi.models.BotInput;
import org.experimentalplayers.hubapi.models.InputType;
import org.springframework.data.domain.Page;

public interface BotInputService {

    Page<BotInput> findAll(Integer page, Integer limit);

    BotInput findByName(String description);


}
