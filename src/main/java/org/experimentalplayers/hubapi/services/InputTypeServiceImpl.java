package org.experimentalplayers.hubapi.services;

import Utils.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.exceptions.NotFoundException;
import org.experimentalplayers.hubapi.models.InputType;
import org.experimentalplayers.hubapi.repositories.InputTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class InputTypeServiceImpl implements InputTypeService{

    @Autowired
    private InputTypeRepository inputTypeRepo;

    @Override
    public Page<InputType> findAll(Integer page, Integer limit) {

        Pageable pageable = new PageUtil(limit,page);

        List<InputType> inputTypes = inputTypeRepo.findAll();

		return new PageImpl<>(inputTypes, pageable, inputTypes.size());
    }

    @Override
    public InputType findByDescription(String description) {

        log.info("Begin findByName(name)... ProjectServiceImpl");

        Optional<InputType> optInputType = inputTypeRepo.findAllByDescription(description);
        if(!optInputType.isPresent())
            throw new NotFoundException();

        log.info("End findByName(name)... ProjectServiceImpl");
        return optInputType.get();
    }

}
