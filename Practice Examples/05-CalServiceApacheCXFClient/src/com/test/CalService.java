package com.test;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.3.2
 * 2019-08-06T18:32:49.191+05:30
 * Generated source version: 3.3.2
 *
 */
@WebService(targetNamespace = "http://test.com/", name = "CalService")
@XmlSeeAlso({ObjectFactory.class})
public interface CalService {

    @WebMethod(action = "urn:Sub")
    @RequestWrapper(localName = "sub", targetNamespace = "http://test.com/", className = "com.test.Sub")
    @ResponseWrapper(localName = "subResponse", targetNamespace = "http://test.com/", className = "com.test.SubResponse")
    @WebResult(name = "return", targetNamespace = "")
    public int sub(

        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1
    );

    @WebMethod(action = "urn:Add")
    @RequestWrapper(localName = "add", targetNamespace = "http://test.com/", className = "com.test.Add")
    @ResponseWrapper(localName = "addResponse", targetNamespace = "http://test.com/", className = "com.test.AddResponse")
    @WebResult(name = "return", targetNamespace = "")
    public int add(

        @WebParam(name = "arg0", targetNamespace = "")
        int arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1
    );
}
