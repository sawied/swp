
package com.danan.services.withXmlElement;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.danan.services.withXmlElement package. 
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
    private final static QName _OpportunitySalesOpportunityNumberC_QNAME = new QName("http://www.danan.org/bean/commons", "Sales_Opportunity_Number__c");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.danan.services.withXmlElement
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FaultInfo }
     * 
     */
    public FaultInfo createFaultInfo() {
        return new FaultInfo();
    }

    /**
     * Create an instance of {@link RetrvApplicationInfoResponse }
     * 
     */
    public RetrvApplicationInfoResponse createRetrvApplicationInfoResponse() {
        return new RetrvApplicationInfoResponse();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link RetrvApplicationInfoRequest }
     * 
     */
    public RetrvApplicationInfoRequest createRetrvApplicationInfoRequest() {
        return new RetrvApplicationInfoRequest();
    }

    /**
     * Create an instance of {@link SObject }
     * 
     */
    public SObject createSObject() {
        return new SObject();
    }

    /**
     * Create an instance of {@link Opportunity }
     * 
     */
    public Opportunity createOpportunity() {
        return new Opportunity();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FaultInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.danan.org/appManagment/", name = "BusinessException")
    public JAXBElement<FaultInfo> createBusinessException(FaultInfo value) {
        return new JAXBElement<FaultInfo>(_BusinessException_QNAME, FaultInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.danan.org/bean/commons", name = "Sales_Opportunity_Number__c", scope = Opportunity.class)
    public JAXBElement<String> createOpportunitySalesOpportunityNumberC(String value) {
        return new JAXBElement<String>(_OpportunitySalesOpportunityNumberC_QNAME, String.class, Opportunity.class, null);
    }

}
