/**
 * CastWebServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.castsoftware.batch;

public class CastWebServiceServiceLocator extends org.apache.axis.client.Service implements com.castsoftware.batch.CastWebServiceService {

    public CastWebServiceServiceLocator() {
    }


    public CastWebServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CastWebServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CastWebServicePort
    private java.lang.String CastWebServicePort_address = "http://vmdevplugin:9898/CastBatchWebService";

    public java.lang.String getCastWebServicePortAddress() {
        return CastWebServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CastWebServicePortWSDDServiceName = "CastWebServicePort";

    public java.lang.String getCastWebServicePortWSDDServiceName() {
        return CastWebServicePortWSDDServiceName;
    }

    public void setCastWebServicePortWSDDServiceName(java.lang.String name) {
        CastWebServicePortWSDDServiceName = name;
    }

    public com.castsoftware.batch.CastWebService getCastWebServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CastWebServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCastWebServicePort(endpoint);
    }

    public com.castsoftware.batch.CastWebService getCastWebServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.castsoftware.batch.CastWebServicePortBindingStub _stub = new com.castsoftware.batch.CastWebServicePortBindingStub(portAddress, this);
            _stub.setPortName(getCastWebServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCastWebServicePortEndpointAddress(java.lang.String address) {
        CastWebServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.castsoftware.batch.CastWebService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.castsoftware.batch.CastWebServicePortBindingStub _stub = new com.castsoftware.batch.CastWebServicePortBindingStub(new java.net.URL(CastWebServicePort_address), this);
                _stub.setPortName(getCastWebServicePortWSDDServiceName());
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
        if ("CastWebServicePort".equals(inputPortName)) {
            return getCastWebServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://batch.castsoftware.com/", "CastWebServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://batch.castsoftware.com/", "CastWebServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CastWebServicePort".equals(portName)) {
            setCastWebServicePortEndpointAddress(address);
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
