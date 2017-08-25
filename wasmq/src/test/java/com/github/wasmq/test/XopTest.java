package com.github.wasmq.test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.avalon.framework.configuration.Configuration;
import org.apache.avalon.framework.configuration.DefaultConfigurationBuilder;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopConfParser;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.FopFactoryBuilder;
import org.apache.fop.apps.MimeConstants;
import org.apache.fop.fonts.apps.TTFReader;
import org.junit.Ignore;
import org.junit.Test;
import org.xml.sax.SAXException;

public class XopTest {

	private final FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
	
	@Ignore
	@Test
	public void testClassloader() {
		try {
			Class.forName("org.apache.batik.bridge.UserAgent");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//@Ignore
	@Test
	public void generatePDFSuccessTest() {
		OutputStream out =null;
		try {
			FopFactoryBuilder ffb = new FopConfParser(new File("fop/fop.xml")).getFopFactoryBuilder();
			FopFactory fopFactory=ffb.build();
			FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
			out = new FileOutputStream(new File("fop/out.pdf"));
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
			 Source src = new StreamSource(new File("fop/template.xml"));
			 Result res = new SAXResult(fop.getDefaultHandler());
			 
			 TransformerFactory factory = TransformerFactory.newInstance();
			 Transformer transformer = factory.newTransformer(); // identity transformer
			 transformer.transform(src, res);
		} catch (SAXException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		
		
		
	
	}
	
	@Ignore
	@Test
	public void fontGenerateTest() {
		String [] args= {"-ttcname","SimSun","fonts/SIMSUN.TTC","fonts/simsun.xml"};
		TTFReader.main(args);
	}
	
	
}
