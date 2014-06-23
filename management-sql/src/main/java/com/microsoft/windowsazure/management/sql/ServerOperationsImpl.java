/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management.sql;

import com.microsoft.windowsazure.core.OperationResponse;
import com.microsoft.windowsazure.core.ServiceOperations;
import com.microsoft.windowsazure.core.pipeline.apache.CustomHttpDelete;
import com.microsoft.windowsazure.core.utils.BOMInputStream;
import com.microsoft.windowsazure.core.utils.XmlUtility;
import com.microsoft.windowsazure.exception.ServiceException;
import com.microsoft.windowsazure.management.sql.models.Server;
import com.microsoft.windowsazure.management.sql.models.ServerChangeAdministratorPasswordParameters;
import com.microsoft.windowsazure.management.sql.models.ServerCreateParameters;
import com.microsoft.windowsazure.management.sql.models.ServerCreateResponse;
import com.microsoft.windowsazure.management.sql.models.ServerListResponse;
import com.microsoft.windowsazure.tracing.CloudTracing;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
* Contains methods to allow various operations on Azure SQL Database Servers.
*/
public class ServerOperationsImpl implements ServiceOperations<SqlManagementClientImpl>, ServerOperations {
    /**
    * Initializes a new instance of the ServerOperationsImpl class.
    *
    * @param client Reference to the service client.
    */
    ServerOperationsImpl(SqlManagementClientImpl client) {
        this.client = client;
    }
    
    private SqlManagementClientImpl client;
    
    /**
    * Gets a reference to the
    * microsoft.windowsazure.management.sql.SqlManagementClientImpl.
    * @return The Client value.
    */
    public SqlManagementClientImpl getClient() {
        return this.client;
    }
    
    /**
    * Changes the administrative password of an existing Azure SQL Database
    * Server for a given subscription.
    *
    * @param serverName Required. The name of the Azure SQL Database Server
    * that will have the administrator password changed.
    * @param parameters Required. The necessary parameters for modifying the
    * adminstrator password for a server.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public Future<OperationResponse> changeAdministratorPasswordAsync(final String serverName, final ServerChangeAdministratorPasswordParameters parameters) {
        return this.getClient().getExecutorService().submit(new Callable<OperationResponse>() { 
            @Override
            public OperationResponse call() throws Exception {
                return changeAdministratorPassword(serverName, parameters);
            }
         });
    }
    
    /**
    * Changes the administrative password of an existing Azure SQL Database
    * Server for a given subscription.
    *
    * @param serverName Required. The name of the Azure SQL Database Server
    * that will have the administrator password changed.
    * @param parameters Required. The necessary parameters for modifying the
    * adminstrator password for a server.
    * @throws ParserConfigurationException Thrown if there was an error
    * configuring the parser for the response body.
    * @throws SAXException Thrown if there was an error parsing the response
    * body.
    * @throws TransformerException Thrown if there was an error creating the
    * DOM transformer.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public OperationResponse changeAdministratorPassword(String serverName, ServerChangeAdministratorPasswordParameters parameters) throws ParserConfigurationException, SAXException, TransformerException, IOException, ServiceException {
        // Validate
        if (serverName == null) {
            throw new NullPointerException("serverName");
        }
        if (parameters == null) {
            throw new NullPointerException("parameters");
        }
        if (parameters.getNewPassword() == null) {
            throw new NullPointerException("parameters.NewPassword");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("serverName", serverName);
            tracingParameters.put("parameters", parameters);
            CloudTracing.enter(invocationId, this, "changeAdministratorPasswordAsync", tracingParameters);
        }
        
        // Construct URL
        String url = "/" + (this.getClient().getCredentials().getSubscriptionId() != null ? this.getClient().getCredentials().getSubscriptionId().trim() : "") + "/services/sqlservers/servers/" + serverName.trim() + "?" + "op=ResetPassword";
        String baseUrl = this.getClient().getBaseUri().toString();
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        
        // Create HTTP transport objects
        HttpPost httpRequest = new HttpPost(url);
        
        // Set Headers
        httpRequest.setHeader("Content-Type", "application/xml");
        httpRequest.setHeader("x-ms-version", "2012-03-01");
        
        // Serialize Request
        String requestContent = null;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document requestDoc = documentBuilder.newDocument();
        
        Element administratorLoginPasswordElement = requestDoc.createElementNS("http://schemas.microsoft.com/sqlazure/2010/12/", "AdministratorLoginPassword");
        requestDoc.appendChild(administratorLoginPasswordElement);
        
        administratorLoginPasswordElement.appendChild(requestDoc.createTextNode(parameters.getNewPassword()));
        
        DOMSource domSource = new DOMSource(requestDoc);
        StringWriter stringWriter = new StringWriter();
        StreamResult streamResult = new StreamResult(stringWriter);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(domSource, streamResult);
        requestContent = stringWriter.toString();
        StringEntity entity = new StringEntity(requestContent);
        httpRequest.setEntity(entity);
        httpRequest.setHeader("Content-Type", "application/xml");
        
        // Send Request
        HttpResponse httpResponse = null;
        try {
            if (shouldTrace) {
                CloudTracing.sendRequest(invocationId, httpRequest);
            }
            httpResponse = this.getClient().getHttpClient().execute(httpRequest);
            if (shouldTrace) {
                CloudTracing.receiveResponse(invocationId, httpResponse);
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                ServiceException ex = ServiceException.createFromXml(httpRequest, requestContent, httpResponse, httpResponse.getEntity());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            OperationResponse result = null;
            result = new OperationResponse();
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").length > 0) {
                result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
            }
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpResponse != null && httpResponse.getEntity() != null) {
                httpResponse.getEntity().getContent().close();
            }
        }
    }
    
    /**
    * Provisions a new SQL Database server in a subscription.
    *
    * @param parameters Required. The parameters needed to provision a server.
    * @return The response returned from the Create Server operation.  This
    * contains all the information returned from the service when a server is
    * created.
    */
    @Override
    public Future<ServerCreateResponse> createAsync(final ServerCreateParameters parameters) {
        return this.getClient().getExecutorService().submit(new Callable<ServerCreateResponse>() { 
            @Override
            public ServerCreateResponse call() throws Exception {
                return create(parameters);
            }
         });
    }
    
    /**
    * Provisions a new SQL Database server in a subscription.
    *
    * @param parameters Required. The parameters needed to provision a server.
    * @throws ParserConfigurationException Thrown if there was an error
    * configuring the parser for the response body.
    * @throws SAXException Thrown if there was an error parsing the response
    * body.
    * @throws TransformerException Thrown if there was an error creating the
    * DOM transformer.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @return The response returned from the Create Server operation.  This
    * contains all the information returned from the service when a server is
    * created.
    */
    @Override
    public ServerCreateResponse create(ServerCreateParameters parameters) throws ParserConfigurationException, SAXException, TransformerException, IOException, ServiceException {
        // Validate
        if (parameters == null) {
            throw new NullPointerException("parameters");
        }
        if (parameters.getAdministratorPassword() == null) {
            throw new NullPointerException("parameters.AdministratorPassword");
        }
        if (parameters.getAdministratorUserName() == null) {
            throw new NullPointerException("parameters.AdministratorUserName");
        }
        if (parameters.getLocation() == null) {
            throw new NullPointerException("parameters.Location");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("parameters", parameters);
            CloudTracing.enter(invocationId, this, "createAsync", tracingParameters);
        }
        
        // Construct URL
        String url = "/" + (this.getClient().getCredentials().getSubscriptionId() != null ? this.getClient().getCredentials().getSubscriptionId().trim() : "") + "/services/sqlservers/servers";
        String baseUrl = this.getClient().getBaseUri().toString();
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        
        // Create HTTP transport objects
        HttpPost httpRequest = new HttpPost(url);
        
        // Set Headers
        httpRequest.setHeader("Content-Type", "application/xml");
        httpRequest.setHeader("x-ms-version", "2012-03-01");
        
        // Serialize Request
        String requestContent = null;
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document requestDoc = documentBuilder.newDocument();
        
        Element serverElement = requestDoc.createElementNS("http://schemas.microsoft.com/sqlazure/2010/12/", "Server");
        requestDoc.appendChild(serverElement);
        
        Element administratorLoginElement = requestDoc.createElementNS("http://schemas.microsoft.com/sqlazure/2010/12/", "AdministratorLogin");
        administratorLoginElement.appendChild(requestDoc.createTextNode(parameters.getAdministratorUserName()));
        serverElement.appendChild(administratorLoginElement);
        
        Element administratorLoginPasswordElement = requestDoc.createElementNS("http://schemas.microsoft.com/sqlazure/2010/12/", "AdministratorLoginPassword");
        administratorLoginPasswordElement.appendChild(requestDoc.createTextNode(parameters.getAdministratorPassword()));
        serverElement.appendChild(administratorLoginPasswordElement);
        
        Element locationElement = requestDoc.createElementNS("http://schemas.microsoft.com/sqlazure/2010/12/", "Location");
        locationElement.appendChild(requestDoc.createTextNode(parameters.getLocation()));
        serverElement.appendChild(locationElement);
        
        if (parameters.getVersion() != null) {
            Element versionElement = requestDoc.createElementNS("http://schemas.microsoft.com/sqlazure/2010/12/", "Version");
            versionElement.appendChild(requestDoc.createTextNode(parameters.getVersion()));
            serverElement.appendChild(versionElement);
        }
        
        DOMSource domSource = new DOMSource(requestDoc);
        StringWriter stringWriter = new StringWriter();
        StreamResult streamResult = new StreamResult(stringWriter);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(domSource, streamResult);
        requestContent = stringWriter.toString();
        StringEntity entity = new StringEntity(requestContent);
        httpRequest.setEntity(entity);
        httpRequest.setHeader("Content-Type", "application/xml");
        
        // Send Request
        HttpResponse httpResponse = null;
        try {
            if (shouldTrace) {
                CloudTracing.sendRequest(invocationId, httpRequest);
            }
            httpResponse = this.getClient().getHttpClient().execute(httpRequest);
            if (shouldTrace) {
                CloudTracing.receiveResponse(invocationId, httpResponse);
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_CREATED) {
                ServiceException ex = ServiceException.createFromXml(httpRequest, requestContent, httpResponse, httpResponse.getEntity());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            ServerCreateResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpResponse.getEntity().getContent();
            result = new ServerCreateResponse();
            DocumentBuilderFactory documentBuilderFactory2 = DocumentBuilderFactory.newInstance();
            documentBuilderFactory2.setNamespaceAware(true);
            DocumentBuilder documentBuilder2 = documentBuilderFactory2.newDocumentBuilder();
            Document responseDoc = documentBuilder2.parse(new BOMInputStream(responseContent));
            
            Element serverNameElement = XmlUtility.getElementByTagNameNS(responseDoc, "http://schemas.microsoft.com/sqlazure/2010/12/", "ServerName");
            if (serverNameElement != null) {
                Attr fullyQualifiedDomainNameAttribute = serverNameElement.getAttributeNodeNS("http://schemas.microsoft.com/sqlazure/2010/12/", "FullyQualifiedDomainName");
                if (fullyQualifiedDomainNameAttribute != null) {
                    result.setFullyQualifiedDomainName(fullyQualifiedDomainNameAttribute.getValue());
                }
                
                result.setServerName(serverNameElement.getTextContent());
            }
            
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").length > 0) {
                result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
            }
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpResponse != null && httpResponse.getEntity() != null) {
                httpResponse.getEntity().getContent().close();
            }
        }
    }
    
    /**
    * Deletes the specified Azure SQL Database Server from a subscription.
    *
    * @param serverName Required. The name of the Azure SQL Database Server to
    * be deleted.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public Future<OperationResponse> deleteAsync(final String serverName) {
        return this.getClient().getExecutorService().submit(new Callable<OperationResponse>() { 
            @Override
            public OperationResponse call() throws Exception {
                return delete(serverName);
            }
         });
    }
    
    /**
    * Deletes the specified Azure SQL Database Server from a subscription.
    *
    * @param serverName Required. The name of the Azure SQL Database Server to
    * be deleted.
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @return A standard service response including an HTTP status code and
    * request ID.
    */
    @Override
    public OperationResponse delete(String serverName) throws IOException, ServiceException {
        // Validate
        if (serverName == null) {
            throw new NullPointerException("serverName");
        }
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            tracingParameters.put("serverName", serverName);
            CloudTracing.enter(invocationId, this, "deleteAsync", tracingParameters);
        }
        
        // Construct URL
        String url = "/" + (this.getClient().getCredentials().getSubscriptionId() != null ? this.getClient().getCredentials().getSubscriptionId().trim() : "") + "/services/sqlservers/servers/" + serverName.trim();
        String baseUrl = this.getClient().getBaseUri().toString();
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        
        // Create HTTP transport objects
        CustomHttpDelete httpRequest = new CustomHttpDelete(url);
        
        // Set Headers
        httpRequest.setHeader("x-ms-version", "2012-03-01");
        
        // Send Request
        HttpResponse httpResponse = null;
        try {
            if (shouldTrace) {
                CloudTracing.sendRequest(invocationId, httpRequest);
            }
            httpResponse = this.getClient().getHttpClient().execute(httpRequest);
            if (shouldTrace) {
                CloudTracing.receiveResponse(invocationId, httpResponse);
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                ServiceException ex = ServiceException.createFromXml(httpRequest, null, httpResponse, httpResponse.getEntity());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            OperationResponse result = null;
            result = new OperationResponse();
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").length > 0) {
                result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
            }
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpResponse != null && httpResponse.getEntity() != null) {
                httpResponse.getEntity().getContent().close();
            }
        }
    }
    
    /**
    * Returns all SQL Database Servers that are provisioned for a subscription.
    *
    * @return The response structure for the Server List operation.  Contains a
    * list of all the servers in a subscription.
    */
    @Override
    public Future<ServerListResponse> listAsync() {
        return this.getClient().getExecutorService().submit(new Callable<ServerListResponse>() { 
            @Override
            public ServerListResponse call() throws Exception {
                return list();
            }
         });
    }
    
    /**
    * Returns all SQL Database Servers that are provisioned for a subscription.
    *
    * @throws IOException Signals that an I/O exception of some sort has
    * occurred. This class is the general class of exceptions produced by
    * failed or interrupted I/O operations.
    * @throws ServiceException Thrown if an unexpected response is found.
    * @throws ParserConfigurationException Thrown if there was a serious
    * configuration error with the document parser.
    * @throws SAXException Thrown if there was an error parsing the XML
    * response.
    * @return The response structure for the Server List operation.  Contains a
    * list of all the servers in a subscription.
    */
    @Override
    public ServerListResponse list() throws IOException, ServiceException, ParserConfigurationException, SAXException {
        // Validate
        
        // Tracing
        boolean shouldTrace = CloudTracing.getIsEnabled();
        String invocationId = null;
        if (shouldTrace) {
            invocationId = Long.toString(CloudTracing.getNextInvocationId());
            HashMap<String, Object> tracingParameters = new HashMap<String, Object>();
            CloudTracing.enter(invocationId, this, "listAsync", tracingParameters);
        }
        
        // Construct URL
        String url = "/" + (this.getClient().getCredentials().getSubscriptionId() != null ? this.getClient().getCredentials().getSubscriptionId().trim() : "") + "/services/sqlservers/servers";
        String baseUrl = this.getClient().getBaseUri().toString();
        // Trim '/' character from the end of baseUrl and beginning of url.
        if (baseUrl.charAt(baseUrl.length() - 1) == '/') {
            baseUrl = baseUrl.substring(0, (baseUrl.length() - 1) + 0);
        }
        if (url.charAt(0) == '/') {
            url = url.substring(1);
        }
        url = baseUrl + "/" + url;
        
        // Create HTTP transport objects
        HttpGet httpRequest = new HttpGet(url);
        
        // Set Headers
        httpRequest.setHeader("x-ms-version", "2012-03-01");
        
        // Send Request
        HttpResponse httpResponse = null;
        try {
            if (shouldTrace) {
                CloudTracing.sendRequest(invocationId, httpRequest);
            }
            httpResponse = this.getClient().getHttpClient().execute(httpRequest);
            if (shouldTrace) {
                CloudTracing.receiveResponse(invocationId, httpResponse);
            }
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                ServiceException ex = ServiceException.createFromXml(httpRequest, null, httpResponse, httpResponse.getEntity());
                if (shouldTrace) {
                    CloudTracing.error(invocationId, ex);
                }
                throw ex;
            }
            
            // Create Result
            ServerListResponse result = null;
            // Deserialize Response
            InputStream responseContent = httpResponse.getEntity().getContent();
            result = new ServerListResponse();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document responseDoc = documentBuilder.parse(new BOMInputStream(responseContent));
            
            Element serversSequenceElement = XmlUtility.getElementByTagNameNS(responseDoc, "http://schemas.microsoft.com/sqlazure/2010/12/", "Servers");
            if (serversSequenceElement != null) {
                for (int i1 = 0; i1 < com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(serversSequenceElement, "http://schemas.microsoft.com/sqlazure/2010/12/", "Server").size(); i1 = i1 + 1) {
                    org.w3c.dom.Element serversElement = ((org.w3c.dom.Element) com.microsoft.windowsazure.core.utils.XmlUtility.getElementsByTagNameNS(serversSequenceElement, "http://schemas.microsoft.com/sqlazure/2010/12/", "Server").get(i1));
                    Server serverInstance = new Server();
                    result.getServers().add(serverInstance);
                    
                    Element nameElement = XmlUtility.getElementByTagNameNS(serversElement, "http://schemas.microsoft.com/sqlazure/2010/12/", "Name");
                    if (nameElement != null) {
                        String nameInstance;
                        nameInstance = nameElement.getTextContent();
                        serverInstance.setName(nameInstance);
                    }
                    
                    Element administratorLoginElement = XmlUtility.getElementByTagNameNS(serversElement, "http://schemas.microsoft.com/sqlazure/2010/12/", "AdministratorLogin");
                    if (administratorLoginElement != null) {
                        String administratorLoginInstance;
                        administratorLoginInstance = administratorLoginElement.getTextContent();
                        serverInstance.setAdministratorUserName(administratorLoginInstance);
                    }
                    
                    Element locationElement = XmlUtility.getElementByTagNameNS(serversElement, "http://schemas.microsoft.com/sqlazure/2010/12/", "Location");
                    if (locationElement != null) {
                        String locationInstance;
                        locationInstance = locationElement.getTextContent();
                        serverInstance.setLocation(locationInstance);
                    }
                    
                    Element fullyQualifiedDomainNameElement = XmlUtility.getElementByTagNameNS(serversElement, "http://schemas.microsoft.com/sqlazure/2010/12/", "FullyQualifiedDomainName");
                    if (fullyQualifiedDomainNameElement != null) {
                        String fullyQualifiedDomainNameInstance;
                        fullyQualifiedDomainNameInstance = fullyQualifiedDomainNameElement.getTextContent();
                        serverInstance.setFullyQualifiedDomainName(fullyQualifiedDomainNameInstance);
                    }
                    
                    Element stateElement = XmlUtility.getElementByTagNameNS(serversElement, "http://schemas.microsoft.com/sqlazure/2010/12/", "State");
                    if (stateElement != null) {
                        String stateInstance;
                        stateInstance = stateElement.getTextContent();
                        serverInstance.setState(stateInstance);
                    }
                    
                    Element versionElement = XmlUtility.getElementByTagNameNS(serversElement, "http://schemas.microsoft.com/sqlazure/2010/12/", "Version");
                    if (versionElement != null) {
                        String versionInstance;
                        versionInstance = versionElement.getTextContent();
                        serverInstance.setVersion(versionInstance);
                    }
                }
            }
            
            result.setStatusCode(statusCode);
            if (httpResponse.getHeaders("x-ms-request-id").length > 0) {
                result.setRequestId(httpResponse.getFirstHeader("x-ms-request-id").getValue());
            }
            
            if (shouldTrace) {
                CloudTracing.exit(invocationId, result);
            }
            return result;
        } finally {
            if (httpResponse != null && httpResponse.getEntity() != null) {
                httpResponse.getEntity().getContent().close();
            }
        }
    }
}
