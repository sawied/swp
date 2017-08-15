package com.github.sawied.ws.model.hub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author wang
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "RespePayload")
public class RespePayload {

    /***/
    @XmlElement(name = "OpDefRespe")
    private OpDefRespe opDefRespe;

    public OpDefRespe getOpDefRespe() {
        return opDefRespe;
    }

    public void setOpDefRespe(OpDefRespe opDefRespe) {
        this.opDefRespe = opDefRespe;
    }

    @Override
    public String toString() {
        return "RespePayload [opDefRespe=" + opDefRespe + "]";
    }

}
