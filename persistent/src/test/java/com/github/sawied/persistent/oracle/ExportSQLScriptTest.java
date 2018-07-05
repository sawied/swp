package com.github.sawied.persistent.oracle;


import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaExport.Action;
import org.hibernate.tool.schema.TargetType;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.sawied.persistent.domain.SearchAuditResponse;
import com.github.sawied.persistent.domain.User;
import com.github.sawied.persistent.domain.UserAuditLog;
import com.github.sawied.persistent.repository.UserAuditLogRepository;
import com.github.sawied.persistent.repository.UserAuditLogRepositoryImpl;
import com.github.sawied.persistent.repository.UserRepository;
import com.github.sawied.persistent.repository.UserRepositoryImpl;

/**
 * 
 * Export SQL script sample
 * @author James X W Zhang
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:jpa-repository-context.xml" })
public class ExportSQLScriptTest extends TestCase {
    
	@Autowired
	private UserAuditLogRepository userAuditLogRepository;
	
	@Autowired
	private UserRepository userRepository;
	

	
	@BeforeClass
	public static void init() throws IllegalStateException, NamingException{
		SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
		DriverManagerDataSource dmds=new DriverManagerDataSource();
		dmds.setDriverClassName("oracle.jdbc.OracleDriver");
		dmds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dmds.setUsername("danan");
		dmds.setPassword("danan");
		builder.bind("jdbc/oracleDS", dmds);
		builder.activate();
	}
	
	@Ignore
	@Test
	public void exportSQLSchema(){
		final BootstrapServiceRegistry bsr = new BootstrapServiceRegistryBuilder().build();
		final StandardServiceRegistryBuilder ssrBuilder = new StandardServiceRegistryBuilder( bsr );
		ssrBuilder.applySetting("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		ssrBuilder.applySetting("javax.persistence.create-database-schemas", true);
		ssrBuilder.applySetting("hibernate.default_schema","danan");
		MetadataSources sources = new MetadataSources(ssrBuilder.build());
		
		Reflections reflections = new Reflections("com.github.sawied.persistent.domain");
		Set<Class<?>> cls=reflections.getTypesAnnotatedWith(javax.persistence.Entity.class);
		Iterator<Class<?>> it=cls.iterator();
		while(it.hasNext()){
			sources.addAnnotatedClass(it.next());
		}
		sources.addPackage(Package.getPackage("com.github.sawied.persistent.domain"));
		SchemaExport schemaExport=new SchemaExport();
		schemaExport.setDelimiter(";");
		schemaExport.setOutputFile("schema.sql");
		schemaExport.execute(EnumSet.of(TargetType.SCRIPT), Action.BOTH, sources.getMetadataBuilder().build());
	}
	
	@Ignore
	@Test
	public void testSearchAuditLogByScalar(){
	    List<SearchAuditResponse> searchAudit = userAuditLogRepository.searchAuditUssScalar();
	    Assert.assertNotNull(searchAudit);
	}
	
	@Ignore
	@Test
	public void testSearchAuditLogByMapping(){
	    List<SearchAuditResponse> searchAudit = userAuditLogRepository.searchAuditUseResultMapping();
	    Assert.assertNotNull(searchAudit);
	}
	
	
	@Ignore
	@Test
	public void testinsertSuccess(){
		UserAuditLog userAuditLog = new UserAuditLog();
		userAuditLog.setCode((short) 400);
		userAuditLog.setMessage("00%000");
		userAuditLog.setStart(new Date(1491579684729L));
		userAuditLog.setEnd(new Date());
		
		User user = new User();
		user.getLogs().add(userAuditLog);
		user.setName("road 2");
		userAuditLog.setUser(user);
		userRepository.save(user);
	}
	
	@Ignore
	@Test
	public void searchAuditLogTest() {
		
		Sort.Order order = new Sort.Order(Direction.ASC, "message");
		Sort sort = new Sort(order);

		PageRequest page = new PageRequest(0, 10, sort);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("message", "0");

		Page<UserAuditLog> result = userAuditLogRepository.searchUserLog(map, page);
		Assert.assertEquals(0, result.getSize());

	}
	
	@Ignore
	@Test
	public void anonymityCall(){
		userRepository.deleteEntity();
	}
	
	

	@Test
	public void sqlInjectTest(){
		//final String name ="%";
		
		userAuditLogRepository.queryUserLogs();
		
		//Assert.assertNotNull(session);
		/**
		 Page<UserAuditLog> page = userAuditLogRepository.findAll(new Specification<UserAuditLog>() {	
			@Override
			public Predicate toPredicate(Root<UserAuditLog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				 return cb.like(root.<String>get("message"), "%{"+name+"}%");
			}
		}, new PageRequest(0,10));
		 
		 assertEquals(1, page.getTotalElements());**/
	}
	
	
}
