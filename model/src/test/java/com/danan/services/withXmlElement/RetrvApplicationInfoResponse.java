
package com.danan.services.withXmlElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="out" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="info" type="{http://www.danan.org/bean/commonSegment}customer"/>
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
    "out",
    "info"
})
@XmlRootElement(name = "retrvApplicationInfoResponse")
public class RetrvApplicationInfoResponse {

    @XmlElement(namespace = "", required = true)
    protected String out;
    @XmlElement(namespace = "", required = true)
    protected Customer info;

    /**
     * Gets the value of the out property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOut() {
        return out;
    }

    /**
     * Sets the value of the out property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOut(String value) {
        this.out = value;
    }

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setInfo(Customer value) {
        this.info = value;
    }

}
