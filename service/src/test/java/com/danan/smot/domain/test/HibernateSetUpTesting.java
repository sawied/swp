package com.danan.smot.domain.test;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:com/danan/database/spring-db-content.xml","classpath:com/danan/database/spring-db-content-test.xml"})
public class HibernateSetUpTesting {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	@Qualifier("oracleDs")
	private DataSource datasource;
	
	@Before
	public void setup(){
		try {
			SimpleNamingContextBuilder currentContextBuilder = new SimpleNamingContextBuilder();
			currentContextBuilder.activate();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void setupSessionFactorySuccess(){
		Assert.assertNotNull(sessionFactory);
	}

}
