
package com.github.sawied.bean.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>sObject complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
@XmlType(name = "sObject", propOrder = {
    "fieldsToNulls"
})
@XmlSeeAlso({
    Opportunity.class
})
public class SObject
    implements Serializable
{

    private final static long serialVersionUID = 1L;
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

    public boolean isSetFieldsToNulls() {
        return ((this.fieldsToNulls!= null)&&(!this.fieldsToNulls.isEmpty()));
    }

    public void unsetFieldsToNulls() {
        this.fieldsToNulls = null;
    }

}
