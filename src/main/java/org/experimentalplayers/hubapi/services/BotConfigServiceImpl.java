package org.experimentalplayers.hubapi.services;

import Utils.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.exceptions.NotFoundException;
import org.experimentalplayers.hubapi.models.BotConfig;
import org.experimentalplayers.hubapi.repositories.BotConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BotConfigServiceImpl implements BotConfigService{

    @Autowired
    private BotConfigRepository botConfigRepo;

    @Override
    public Page<BotConfig> findAll(Integer page, Integer limit) {

        Pageable pageable = new PageUtil(limit,page);

        List<BotConfig> botConfigs = botConfigRepo.findAll();

		return new PageImpl<>(botConfigs, pageable, botConfigs.size());
    }

    @Override
    public BotConfig findByIdServer(Long idServer) {

        log.info("Begin findByName(name)... ProjectServiceImpl");

        Optional<BotConfig> botConfig = botConfigRepo.findAllByIdServer(idServer);
        if(!botConfig.isPresent())
            throw new NotFoundException();

        log.info("End findByName(name)... ProjectServiceImpl");
        return botConfig.get();
    }

}
