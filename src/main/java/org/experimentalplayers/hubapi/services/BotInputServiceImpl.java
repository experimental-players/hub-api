package org.experimentalplayers.hubapi.services;

import Utils.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.exceptions.NotFoundException;
import org.experimentalplayers.hubapi.models.BotInput;
import org.experimentalplayers.hubapi.models.InputType;
import org.experimentalplayers.hubapi.repositories.BotInputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BotInputServiceImpl implements BotInputService{

    @Autowired
    private BotInputRepository botInputRepo;

    @Override
    public Page<BotInput> findAll(Integer page, Integer limit) {

        Pageable pageable = new PageUtil(limit,page);

        List<BotInput> botInputs = botInputRepo.findAll();
        Page<BotInput> botInputPage = new PageImpl<BotInput>(botInputs, pageable, botInputs.size());

        return botInputPage;
    }

    @Override
    public BotInput findByName(String name) {

        log.info("Begin findByName(name)... ProjectServiceImpl");

        Optional<BotInput> botInput = botInputRepo.findAllByName(name);
        if(!botInput.isPresent())
            throw new NotFoundException();

        log.info("End findByName(name)... ProjectServiceImpl");
        return botInput.get();
    }
}
