package com.github.sawied.ws.model.hub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 
 * @author wang
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpDefRqst", propOrder = {
        "seq",
        "value"
    })
public class OpDefRqst {

    /***/
    @XmlCDATA
    @XmlValue
    private String value;
    /***/
    @XmlAttribute(name = "seq")
    private String seq;

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    /**
     * 
     */
    public OpDefRqst() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param value
     *            value
     */
    public OpDefRqst(String value) {
        super();
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
