
package org.danan.appmanagment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.danan.bean.commonsegment.FaultInfo;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.danan.appmanagment package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _BusinessException_QNAME = new QName("http://www.danan.org/appManagment/", "BusinessException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.danan.appmanagment
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RetrvApplicationInfoResponse }
     * 
     */
    public RetrvApplicationInfoResponse createRetrvApplicationInfoResponse() {
        return new RetrvApplicationInfoResponse();
    }

    /**
     * Create an instance of {@link RetrvApplicationInfoRequest }
     * 
     */
    public RetrvApplicationInfoRequest createRetrvApplicationInfoRequest() {
        return new RetrvApplicationInfoRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.danan.org/appManagment/", name = "BusinessException")
    public JAXBElement<FaultInfo> createBusinessException(FaultInfo value) {
        return new JAXBElement<FaultInfo>(_BusinessException_QNAME, FaultInfo.class, null, value);
    }

}
