package com.github.sawied.jweb.entity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLXML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class HibernateXMLType implements UserType, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 138748049412963932L;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateXMLType.class);
	
	private static final Class<byte[]> returnedClass = byte[].class;
	
	private static final int[] SQL_TYPES = new int[] { java.sql.Types.SQLXML };
	

	@Override
	public int[] sqlTypes() {
		return SQL_TYPES;
	}

	@Override
	public Class<byte[]> returnedClass() {
		return returnedClass;
	}

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		if(x == null && y == null) return true;
		else if (x == null && y != null ) return false;
	    else return x.equals(y);
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		return x.hashCode();
	}

	@Override
	public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session, Object owner)
			throws HibernateException, SQLException {
			SQLXML sqlxml=rs.getSQLXML(names[0]);
			try {
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				ByteArrayOutputStream byteArray=new ByteArrayOutputStream();
				
				transformer.transform(sqlxml.getSource(DOMSource.class), new StreamResult(byteArray));
				
				return byteArray.toByteArray();
				
			} catch (TransformerFactoryConfigurationError | TransformerException e) {
				e.printStackTrace();
			}
			return null;
	}

	@Override
	public void nullSafeSet(PreparedStatement st, Object value, int index, SessionImplementor session)
			throws HibernateException, SQLException {
		   LOGGER.debug("  nullSafeSet: " + value + ", ps: " + st + ", index: " + index);
		   if(value!=null) {
				SQLXML sqlxml = st.getConnection().createSQLXML();
				DOMResult domResult=sqlxml.setResult(DOMResult.class);
				try {
					
					javax.xml.parsers.DocumentBuilderFactory factory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
					factory.setNamespaceAware(true);
					DocumentBuilder builder = factory.newDocumentBuilder();
					Document doc = builder.parse(new ByteArrayInputStream((byte[])value));
					domResult.setNode(doc);
					st.setSQLXML(index, sqlxml);
				} catch (TransformerFactoryConfigurationError | ParserConfigurationException | SAXException | IOException e) {
					e.printStackTrace();
				}
		   }
		   
	}

	@Override
	public Object deepCopy(Object value) throws HibernateException {
		 if (value == null) {
		        return null;
		    } else {
		        return value;
		    }
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable)value;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return null;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

}
