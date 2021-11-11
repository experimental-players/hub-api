package org.experimentalplayers.hubapi.services;

import org.experimentalplayers.hubapi.models.InputType;
import org.springframework.data.domain.Page;

public interface InputTypeService {

    Page<InputType> findAll(Integer page, Integer limit);

    InputType findByDescription(String description);

}
