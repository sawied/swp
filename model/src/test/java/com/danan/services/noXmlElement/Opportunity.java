
package com.danan.services.noXmlElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Opportunity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Opportunity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.danan.org/bean/commons}sObject">
 *       &lt;sequence>
 *         &lt;element name="Sales_Opportunity_Number__c" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Opportunity", namespace = "http://www.danan.org/bean/commons", propOrder = {
    "salesOpportunityNumberC"
})
public class Opportunity
    extends SObject
{

    @XmlElement(name = "Sales_Opportunity_Number__c", nillable = true)
    protected String salesOpportunityNumberC;

    /**
     * Gets the value of the salesOpportunityNumberC property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalesOpportunityNumberC() {
        return salesOpportunityNumberC;
    }

    /**
     * Sets the value of the salesOpportunityNumberC property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalesOpportunityNumberC(String value) {
        this.salesOpportunityNumberC = value;
    }

}
