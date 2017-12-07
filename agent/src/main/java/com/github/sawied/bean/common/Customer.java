
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
 * <p>customer complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡname���Ե�ֵ��
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
     * ����name���Ե�ֵ��
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
     * ��ȡimgData���Ե�ֵ��
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
     * ����imgData���Ե�ֵ��
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
     * ��ȡattachment���Ե�ֵ��
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
     * ����attachment���Ե�ֵ��
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
     * ��ȡplainType���Ե�ֵ��
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
     * ����plainType���Ե�ֵ��
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
     * ��ȡhasPage���Ե�ֵ��
     * 
     */
    public boolean isHasPage() {
        return hasPage;
    }

    /**
     * ����hasPage���Ե�ֵ��
     * 
     */
    public void setHasPage(boolean value) {
        this.hasPage = value;
    }

    public boolean isSetHasPage() {
        return true;
    }

}
