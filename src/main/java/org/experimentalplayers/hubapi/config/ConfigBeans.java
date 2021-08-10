package org.experimentalplayers.hubapi.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ConfigBeans {

	@Bean
	public DataSource getDatasource(@Value("${application.datasource.url}") String url,
			@Value("${application.datasource.username}") String username,
			@Value("${application.datasource.password}") String password) {

		return DataSourceBuilder.create()
				.type(HikariDataSource.class)
				.driverClassName("org.postgresql.Driver")
				.url(url)
				.username(username)
				.password(password)
				.build();

	}

}
