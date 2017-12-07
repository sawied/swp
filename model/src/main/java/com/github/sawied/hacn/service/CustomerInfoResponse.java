
package com.github.sawied.hacn.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.github.sawied.hacn.entity.CustomerInfo;



/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerInfoReturn" type="{http://entity.hangseng.com}CustomerInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "customerInfoReturn"
})
@XmlRootElement(name = "customerInfoResponse")
public class CustomerInfoResponse {

    @XmlElement(required = true,namespace="http://entity.hangseng.com")
    protected CustomerInfo customerInfoReturn;

    /**
     * Gets the value of the customerInfoReturn property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerInfo }
     *     
     */
    public CustomerInfo getCustomerInfoReturn() {
        return customerInfoReturn;
    }

    /**
     * Sets the value of the customerInfoReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerInfo }
     *     
     */
    public void setCustomerInfoReturn(CustomerInfo value) {
        this.customerInfoReturn = value;
    }

}
