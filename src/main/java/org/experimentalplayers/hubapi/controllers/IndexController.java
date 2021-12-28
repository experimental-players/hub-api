package org.experimentalplayers.hubapi.controllers;

import lombok.extern.slf4j.Slf4j;
import org.experimentalplayers.hubapi.config.InfoBean;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class IndexController extends BaseController {

	private final InfoBean info;

	public IndexController(InfoBean info) {
		this.info = info;
	}

	@GetMapping("/")
	public HttpEntity<?> index() {

		return new HttpEntity<>(info);

	}

}
