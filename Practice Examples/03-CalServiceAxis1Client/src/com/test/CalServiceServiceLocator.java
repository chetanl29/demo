/**
 * CalServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.test;

public class CalServiceServiceLocator extends org.apache.axis.client.Service implements com.test.CalServiceService {

    public CalServiceServiceLocator() {
    }


    public CalServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CalServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CalService
    private java.lang.String CalService_address = "http://localhost:8567/03-CalServiceAxis1/services/CalService";

    public java.lang.String getCalServiceAddress() {
        return CalService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CalServiceWSDDServiceName = "CalService";

    public java.lang.String getCalServiceWSDDServiceName() {
        return CalServiceWSDDServiceName;
    }

    public void setCalServiceWSDDServiceName(java.lang.String name) {
        CalServiceWSDDServiceName = name;
    }

    public com.test.CalService getCalService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CalService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCalService(endpoint);
    }

    public com.test.CalService getCalService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.test.CalServiceSoapBindingStub _stub = new com.test.CalServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getCalServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCalServiceEndpointAddress(java.lang.String address) {
        CalService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.test.CalService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.test.CalServiceSoapBindingStub _stub = new com.test.CalServiceSoapBindingStub(new java.net.URL(CalService_address), this);
                _stub.setPortName(getCalServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CalService".equals(inputPortName)) {
            return getCalService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://test.com", "CalServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://test.com", "CalService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CalService".equals(portName)) {
            setCalServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
