package com.github.sawied.jweb.config;

import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages= {"com.github.sawied.jweb.repository"},repositoryImplementationPostfix="Impl")
public class JPARepositoryConfig {
	
	
	@Bean
	DataSource datasource() throws SQLException {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("user");
		ds.setPassword("password");
		return ds;
	}
	
	
	@Bean
	PlatformTransactionManager transactionManager(EntityManagerFactory emf){
		JpaTransactionManager transactionManager=new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}
	
	/**
	 * 
	@Profile("pro")
	@Primary
	@Bean
	DataSource datasource() throws SQLException {
		JndiObjectFactoryBean jndi=new JndiObjectFactoryBean();
		jndi.setJndiName("jdbc/datasource");
		jndi.setExpectedType(javax.sql.DataSource.class);
		return (DataSource) jndi.getObject();
	}
**/

}
