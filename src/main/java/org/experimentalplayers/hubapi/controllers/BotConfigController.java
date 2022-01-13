package org.experimentalplayers.hubapi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.config.BotConfigMappings;
import org.experimentalplayers.hubapi.exceptions.NotFoundException;
import org.experimentalplayers.hubapi.models.BotConfig;
import org.experimentalplayers.hubapi.services.BotConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(BotConfigMappings.ROOT)
public class BotConfigController extends BaseController {

	@Autowired
	BotConfigService botConfigService;

	@GetMapping(BotConfigMappings.FIND_ALL)
	public HttpEntity<?> findAll(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer limit) {

		log.info("Begin findAll()...");

		Page<BotConfig> botConfigPage = botConfigService.findAll(page, limit);

		log.info(botConfigPage.toString());

		log.info("End findAll()...");
		return new HttpEntity<>(botConfigPage);

	}

	@GetMapping(BotConfigMappings.FIND_BY_IDSERVER)
	public HttpEntity<?> findByName(@PathVariable Long idServer) throws NotFoundException {

		log.info("Begin findByName()...");

		BotConfig botConfig = botConfigService.findByIdServer(idServer);

		log.info("End findByName()...");
		return new HttpEntity<>(botConfig);

	}

}
