package com.github.sawied.ws.model.hub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import org.eclipse.persistence.oxm.annotations.XmlCDATA;

/**
 * 
 * @author wang
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "OpDefRespe")
public class OpDefRespe {

    /***/
    @XmlValue
    @XmlCDATA
    private String request;
    /***/
    @XmlAttribute(name = "seq")
    private String seq;

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "OpDefRespe [request=" + request + ", seq=" + seq + "]";
    }

}
