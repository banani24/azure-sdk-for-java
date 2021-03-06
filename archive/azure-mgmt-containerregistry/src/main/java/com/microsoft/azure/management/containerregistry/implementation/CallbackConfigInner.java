/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.containerregistry.implementation;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The configuration of service URI and custom headers for the webhook.
 */
public class CallbackConfigInner {
    /**
     * The service URI for the webhook to post notifications.
     */
    @JsonProperty(value = "serviceUri", required = true)
    private String serviceUri;

    /**
     * Custom headers that will be added to the webhook notifications.
     */
    @JsonProperty(value = "customHeaders")
    private Map<String, String> customHeaders;

    /**
     * Get the serviceUri value.
     *
     * @return the serviceUri value
     */
    public String serviceUri() {
        return this.serviceUri;
    }

    /**
     * Set the serviceUri value.
     *
     * @param serviceUri the serviceUri value to set
     * @return the CallbackConfigInner object itself.
     */
    public CallbackConfigInner withServiceUri(String serviceUri) {
        this.serviceUri = serviceUri;
        return this;
    }

    /**
     * Get the customHeaders value.
     *
     * @return the customHeaders value
     */
    public Map<String, String> customHeaders() {
        return this.customHeaders;
    }

    /**
     * Set the customHeaders value.
     *
     * @param customHeaders the customHeaders value to set
     * @return the CallbackConfigInner object itself.
     */
    public CallbackConfigInner withCustomHeaders(Map<String, String> customHeaders) {
        this.customHeaders = customHeaders;
        return this;
    }

}
