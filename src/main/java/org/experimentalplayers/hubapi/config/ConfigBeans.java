package org.experimentalplayers.hubapi.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
public class ConfigBeans {

	@Bean
	public DataSource getDatasource() {

		return DataSourceBuilder.create()
				.type(HikariDataSource.class)
				.driverClassName("org.postgresql.Driver")
				.url(Objects.requireNonNull(System.getenv("DATASOURCE_URL")))
				.username(Objects.requireNonNull(System.getenv("DATASOURCE_USERNAME")))
				.password(Objects.requireNonNull(System.getenv("DATASOURCE_PASSWORD")))
				.build();

	}

}
