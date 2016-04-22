
package com.danan.services.noXmlElement;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sObject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sObject">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fieldsToNull" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sObject", namespace = "http://www.danan.org/bean/commons", propOrder = {
    "fieldsToNulls"
})
@XmlSeeAlso({
    Opportunity.class
})
public class SObject {

    @XmlElement(name = "fieldsToNull", nillable = true)
    protected List<String> fieldsToNulls;

    /**
     * Gets the value of the fieldsToNulls property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fieldsToNulls property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFieldsToNulls().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFieldsToNulls() {
        if (fieldsToNulls == null) {
            fieldsToNulls = new ArrayList<String>();
        }
        return this.fieldsToNulls;
    }

}
