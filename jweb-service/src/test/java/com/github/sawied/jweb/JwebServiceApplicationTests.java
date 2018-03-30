package com.github.sawied.jweb;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLXML;

import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.github.sawied.jweb.entity.User;
import com.github.sawied.jweb.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JwebServiceApplication.class)
public class JwebServiceApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DataSource ds;

	@Test
	public void saveUserTest() throws IOException, ParserConfigurationException, SAXException {
		User user = new User();
		user.setName("dan");
		ClassPathResource notes = new ClassPathResource("com/github/sawied/jweb/notes.xml");
		user.setXmlData(IOUtils.toByteArray(notes.getInputStream()));
		userRepository.save(user);
	}

	@Test
	public void queryXmlDataTest() throws TransformerFactoryConfigurationError, TransformerException, FileNotFoundException {
		User user = userRepository.findOne(62L);
		System.out.println(new String(user.getXmlData()));
	}

	@Ignore
	@Test
	public void sqlxmlUpdateTest() throws SQLException, IOException, ParserConfigurationException, SAXException {

		Connection connection = ds.getConnection();
		connection.setAutoCommit(false);
		PreparedStatement statement = connection.prepareStatement("update users set xml_data=? where id=?");
		SQLXML sqlxml = connection.createSQLXML();
		DOMResult domResult=sqlxml.setResult(DOMResult.class);
		domResult.setNode(buildDoc());
		statement.setSQLXML(1, sqlxml);
		statement.setInt(2, 3);
		statement.execute();
		connection.commit();
		connection.close();
	}
	
	@Ignore
	@Test
	public void sqlxmlQueryTest() throws SQLException, IOException, ParserConfigurationException, SAXException {
		Connection connection = ds.getConnection();
		connection.setAutoCommit(false);
		PreparedStatement statement = connection.prepareStatement("select xml_data,name from users  where id=?");
		statement.setInt(1, 3);
		ResultSet result = statement.executeQuery();
		while(result.next()) {
			SQLXML sqlxml=result.getSQLXML(1);
			
			String name =result.getString(2);
			
			System.out.println(name);
			
			String binaryStream = sqlxml.getString();

			System.out.println(binaryStream);
		}
		connection.commit();
		connection.close();
	}

	private Document buildDoc() throws ParserConfigurationException, SAXException, IOException {
		ClassPathResource notes = new ClassPathResource("com/github/sawied/jweb/notes.xml");
		javax.xml.parsers.DocumentBuilderFactory factory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(notes.getInputStream());
		return doc;
	}

}
