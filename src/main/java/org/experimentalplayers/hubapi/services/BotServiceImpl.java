package org.experimentalplayers.hubapi.services;

import Utils.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.exceptions.NotFoundException;
import org.experimentalplayers.hubapi.models.Bot;
import org.experimentalplayers.hubapi.repositories.BotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BotServiceImpl implements BotService{

    @Autowired
    private BotRepository botRepo;

    @Override
    public Page<Bot> findAll(Integer page, Integer limit) {

        Pageable pageable = new PageUtil(limit,page);

        List<Bot> bots = botRepo.findAll();

		return new PageImpl<Bot>(bots, pageable, bots.size());
    }

    @Override
    public Bot findByName(String name) {

        log.info("Begin findByName(name)... ProjectServiceImpl");

        Optional<Bot> optBot = botRepo.findAllByName(name);
        if(!optBot.isPresent())
            throw new NotFoundException();

        log.info("End findByName(name)... ProjectServiceImpl");
        return optBot.get();
    }

}
