package org.experimentalplayers.hubapi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.config.BotInputMappings;
import org.experimentalplayers.hubapi.exceptions.NotFoundException;
import org.experimentalplayers.hubapi.models.BotInput;
import org.experimentalplayers.hubapi.services.BotInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(BotInputMappings.ROOT)
public class BotInputController {

	@Autowired
	BotInputService botInputService;

	@GetMapping(BotInputMappings.FIND_ALL)
	public HttpEntity<?> findAll(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer limit) {

		log.info("Begin findAll()...");

		Page<BotInput> botInputPage = botInputService.findAll(page, limit);

		log.info(botInputPage.toString());

		log.info("End findAll()...");
		return new HttpEntity<>(botInputPage);

	}

	@GetMapping(BotInputMappings.FIND_BY_NAME)
	public HttpEntity<?> findByName(@PathVariable String name) throws NotFoundException {

		log.info("Begin findByName()...");

		BotInput botInput = botInputService.findByName(name);

		log.info("End findByName()...");
		return new HttpEntity<>(botInput);

	}

}
