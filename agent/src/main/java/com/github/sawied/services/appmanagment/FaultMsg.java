
package com.github.sawied.services.appmanagment;

import javax.xml.ws.WebFault;
import com.github.sawied.bean.common.BusinessException;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "BusinessException", targetNamespace = "http://www.github.com/sawied/services/appManagment")
public class FaultMsg
    extends Exception
{

    /**
     * 
     */
    private static final long serialVersionUID = -7281325019619289673L;
    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private BusinessException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public FaultMsg(String message, BusinessException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public FaultMsg(String message, BusinessException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: com.github.sawied.bean.common.BusinessException
     */
    public BusinessException getFaultInfo() {
        return faultInfo;
    }

}
