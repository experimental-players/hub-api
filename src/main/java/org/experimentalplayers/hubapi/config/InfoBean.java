package org.experimentalplayers.hubapi.config;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@ToString
@Component
public class InfoBean {

	private final String description;

	private final String version;

	private final String docs_url;

	private final String[] credits;

	public InfoBean(@Value("${application.description}") String description,
			@Value("${application.version}") String version, @Value("${application.docs.url}") String docs_url,
			@Value("${application.credits}") String[] credits) {
		this.description = description;
		this.version = version;
		this.docs_url = docs_url;
		this.credits = credits;
	}

}

