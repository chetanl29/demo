package com.test.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/*@Configuration
@ComponentScan(basePackages = "com.test")*/
@SpringBootApplication(scanBasePackages = "com.test")
public class JdbcConfig {
	
	/*@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
		dataSource.setUrl("jdbc:hsqldb:hsql://localhost/");
		dataSource.setUsername("SA");
		dataSource.setPassword("");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
		return jdbcTemplate;
	}*/

}
