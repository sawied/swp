
package com.github.sawied.cxf;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "SOAPService", targetNamespace = "http://sawied.github.com/cxf", wsdlLocation = "file:/D:/works/wsdl/hello_world_soap12.wsdl")
public class SOAPService
    extends Service
{

    private final static URL SOAPSERVICE_WSDL_LOCATION;
    private final static WebServiceException SOAPSERVICE_EXCEPTION;
    private final static QName SOAPSERVICE_QNAME = new QName("http://sawied.github.com/cxf", "SOAPService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/D:/works/wsdl/hello_world_soap12.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SOAPSERVICE_WSDL_LOCATION = url;
        SOAPSERVICE_EXCEPTION = e;
    }

    public SOAPService() {
        super(__getWsdlLocation(), SOAPSERVICE_QNAME);
    }

    public SOAPService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SOAPSERVICE_QNAME, features);
    }

    public SOAPService(URL wsdlLocation) {
        super(wsdlLocation, SOAPSERVICE_QNAME);
    }

    public SOAPService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SOAPSERVICE_QNAME, features);
    }

    public SOAPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SOAPService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns Greeter
     */
    @WebEndpoint(name = "SoapPort")
    public Greeter getSoapPort() {
        return super.getPort(new QName("http://sawied.github.com/cxf", "SoapPort"), Greeter.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Greeter
     */
    @WebEndpoint(name = "SoapPort")
    public Greeter getSoapPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://sawied.github.com/cxf", "SoapPort"), Greeter.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SOAPSERVICE_EXCEPTION!= null) {
            throw SOAPSERVICE_EXCEPTION;
        }
        return SOAPSERVICE_WSDL_LOCATION;
    }

}
