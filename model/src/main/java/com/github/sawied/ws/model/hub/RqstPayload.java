package com.github.sawied.ws.model.hub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author wang
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
/**
 * 
 * @author danan
 *
@XmlType(name = "RqstPayload", propOrder = {
        "opDefRqst"
    })
 */
public class RqstPayload {

    /***/
    @XmlElement(name = "OpDefRqst")
    private OpDefRqst opDefRqst;

    public OpDefRqst getOpDefRqst() {
        return opDefRqst;
    }

    public void setOpDefRqst(OpDefRqst opDefRqst) {
        this.opDefRqst = opDefRqst;
    }

}
