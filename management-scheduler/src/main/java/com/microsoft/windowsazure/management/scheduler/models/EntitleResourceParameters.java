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

package com.microsoft.windowsazure.management.scheduler.models;

import java.util.Calendar;

public class EntitleResourceParameters {
    private Calendar registrationDate;
    
    /**
    * Required. The required data when the entitlement is performed.
    * @return The RegistrationDate value.
    */
    public Calendar getRegistrationDate() {
        return this.registrationDate;
    }
    
    /**
    * Required. The required data when the entitlement is performed.
    * @param registrationDateValue The RegistrationDate value.
    */
    public void setRegistrationDate(final Calendar registrationDateValue) {
        this.registrationDate = registrationDateValue;
    }
    
    private String resourceNamespace;
    
    /**
    * Required. Required NameSpace identifier for the resource provider.
    * @return The ResourceNamespace value.
    */
    public String getResourceNamespace() {
        return this.resourceNamespace;
    }
    
    /**
    * Required. Required NameSpace identifier for the resource provider.
    * @param resourceNamespaceValue The ResourceNamespace value.
    */
    public void setResourceNamespace(final String resourceNamespaceValue) {
        this.resourceNamespace = resourceNamespaceValue;
    }
    
    private String resourceType;
    
    /**
    * Required. Required type for the resource.
    * @return The ResourceType value.
    */
    public String getResourceType() {
        return this.resourceType;
    }
    
    /**
    * Required. Required type for the resource.
    * @param resourceTypeValue The ResourceType value.
    */
    public void setResourceType(final String resourceTypeValue) {
        this.resourceType = resourceTypeValue;
    }
    
    /**
    * Initializes a new instance of the EntitleResourceParameters class.
    *
    */
    public EntitleResourceParameters() {
    }
    
    /**
    * Initializes a new instance of the EntitleResourceParameters class with
    * required arguments.
    *
    */
    public EntitleResourceParameters(String resourceNamespace, String resourceType, Calendar registrationDate) {
        if (resourceNamespace == null) {
            throw new NullPointerException("resourceNamespace");
        }
        if (resourceType == null) {
            throw new NullPointerException("resourceType");
        }
        this.setResourceNamespace(resourceNamespace);
        this.setResourceType(resourceType);
        this.setRegistrationDate(registrationDate);
    }
}
