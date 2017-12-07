package com.github.sawied.websocket;

import java.io.File;
import java.io.IOException;

import org.springframework.util.FileCopyUtils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class WebSocketAppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public WebSocketAppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( WebSocketAppTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws IOException 
     */
    public void testApp() throws IOException
    {
        assertTrue( true );
       File file= new File(".","../../a.pdf");
       FileCopyUtils.copy("Hello".getBytes(),file);
        
    }
}
