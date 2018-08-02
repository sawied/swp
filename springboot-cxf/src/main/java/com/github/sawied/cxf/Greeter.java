
package com.github.sawied.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import com.github.sawied.cxf.types.ObjectFactory;

@WebService(name = "Greeter", targetNamespace = "http://sawied.github.com/cxf")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Greeter {


    /**
     * 
     * @param request
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "response", targetNamespace = "http://sawied.github.com/cxf/types")
    @RequestWrapper(localName = "sayHi", targetNamespace = "http://sawied.github.com/cxf/types", className = "com.github.sawied.cxf.types.SayHi")
    @ResponseWrapper(localName = "sayHiResponse", targetNamespace = "http://sawied.github.com/cxf/types", className = "com.github.sawied.cxf.types.SayHiResponse")
    public String sayHi(
        @WebParam(name = "request", targetNamespace = "http://sawied.github.com/cxf/types")
        String request);

}
