
package com.github.sawied.bean.base;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Opportunity complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="Opportunity">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.github.com/sawied/bean/base}sObject">
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
@XmlType(name = "Opportunity", propOrder = {
    "salesOpportunityNumberC"
})
public class Opportunity
    extends SObject
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Sales_Opportunity_Number__c", nillable = true)
    protected String salesOpportunityNumberC;

    /**
     * 获取salesOpportunityNumberC属性的值。
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
     * 设置salesOpportunityNumberC属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalesOpportunityNumberC(String value) {
        this.salesOpportunityNumberC = value;
    }

    public boolean isSetSalesOpportunityNumberC() {
        return (this.salesOpportunityNumberC!= null);
    }

}
