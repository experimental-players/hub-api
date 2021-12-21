package org.experimentalplayers.hubapi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.config.BotMappings;
import org.experimentalplayers.hubapi.exceptions.NotFoundException;
import org.experimentalplayers.hubapi.models.Bot;
import org.experimentalplayers.hubapi.services.BotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <h2>Application sub-API</h2>
 * <p>
 * The REST controller that listens for every {@link Bot Application} query.
 * <br><br>
 * This controller listens on {@link BotMappings#ROOT this} path,
 * so the endpoint for all mapped methods will be /{@link BotMappings#ROOT APPLICATION_ROOT}/METHOD_MAPPING (with no trailing slash).
 * </p>
 */
@Slf4j
@RestController
@RequestMapping(BotMappings.ROOT)
public class BotController {

	@Autowired
	BotService botService;

	@GetMapping(BotMappings.FIND_ALL)
	public HttpEntity<?> findAll(@RequestParam(defaultValue = "1") Integer page,
								 @RequestParam(defaultValue = "10") Integer limit) {

		log.info("Begin findAll()...");
		;
		Page<Bot> botPage = botService.findAll(page,limit);

		log.info(botPage.toString());

		log.info("End findAll()...");
		return new HttpEntity<>(botPage);

	}

	@GetMapping(BotMappings.FIND_BY_NAME)
	public HttpEntity<?> findByName(@PathVariable String name) throws NotFoundException {

		log.info("Begin findByName()...");

		Bot bot = botService.findByName(name);

		log.info("End findByName()...");
		return new HttpEntity<>(bot);

	}

}
