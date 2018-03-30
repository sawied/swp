package com.github.sawied.jweb.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableJpaRepositories(basePackages= {"com.github.sawied.jweb.repository"},repositoryImplementationPostfix="Impl")
public class JPARepositoryConfig {
	
	
	@Bean
	DataSource datasource() throws SQLException {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("danan");
		ds.setPassword("danan");
		return ds;
	}

}
