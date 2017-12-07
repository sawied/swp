
package com.github.sawied.services.appmanagment;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.github.sawied.bean.common.Customer;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="out" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="info" type="{http://www.github.com/sawied/bean/common}customer"/>
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
public class RetrvApplicationInfoResponse
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String out;
    @XmlElement(required = true)
    protected Customer info;

    /**
     * 获取out属性的值。
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
     * 设置out属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOut(String value) {
        this.out = value;
    }

    public boolean isSetOut() {
        return (this.out!= null);
    }

    /**
     * 获取info属性的值。
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
     * 设置info属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setInfo(Customer value) {
        this.info = value;
    }

    public boolean isSetInfo() {
        return (this.info!= null);
    }

}
