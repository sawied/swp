
package com.github.sawied.bean.common;

import java.io.Serializable;
import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;
import com.github.sawied.bean.base.Opportunity;


/**
 * <p>customer complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="customer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="imgData" type="{http://www.github.com/sawied/bean/common}img"/>
 *         &lt;element name="attachment" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element name="plainType" type="{http://www.github.com/sawied/bean/base}Opportunity"/>
 *         &lt;element name="hasPage" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customer", propOrder = {
    "name",
    "imgData",
    "attachment",
    "plainType",
    "hasPage"
})
public class Customer
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    @XmlMimeType("application/octet-stream")
    protected DataHandler imgData;
    @XmlElement(required = true)
    @XmlMimeType("application/octet-stream")
    protected DataHandler attachment;
    @XmlElement(required = true)
    protected Opportunity plainType;
    protected boolean hasPage;

    /**
     * 获取name属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * 获取imgData属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DataHandler }
     *     
     */
    public DataHandler getImgData() {
        return imgData;
    }

    /**
     * 设置imgData属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DataHandler }
     *     
     */
    public void setImgData(DataHandler value) {
        this.imgData = value;
    }

    public boolean isSetImgData() {
        return (this.imgData!= null);
    }

    /**
     * 获取attachment属性的值。
     * 
     * @return
     *     possible object is
     *     {@link DataHandler }
     *     
     */
    public DataHandler getAttachment() {
        return attachment;
    }

    /**
     * 设置attachment属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link DataHandler }
     *     
     */
    public void setAttachment(DataHandler value) {
        this.attachment = value;
    }

    public boolean isSetAttachment() {
        return (this.attachment!= null);
    }

    /**
     * 获取plainType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Opportunity }
     *     
     */
    public Opportunity getPlainType() {
        return plainType;
    }

    /**
     * 设置plainType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Opportunity }
     *     
     */
    public void setPlainType(Opportunity value) {
        this.plainType = value;
    }

    public boolean isSetPlainType() {
        return (this.plainType!= null);
    }

    /**
     * 获取hasPage属性的值。
     * 
     */
    public boolean isHasPage() {
        return hasPage;
    }

    /**
     * 设置hasPage属性的值。
     * 
     */
    public void setHasPage(boolean value) {
        this.hasPage = value;
    }

    public boolean isSetHasPage() {
        return true;
    }

}
