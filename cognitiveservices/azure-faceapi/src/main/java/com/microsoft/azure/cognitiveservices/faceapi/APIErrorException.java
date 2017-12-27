/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.microsoft.azure.cognitiveservices.faceapi;

import com.microsoft.rest.RestException;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Exception thrown for an invalid response with APIError information.
 */
public class APIErrorException extends RestException {
    /**
     * Initializes a new instance of the APIErrorException class.
     *
     * @param message the exception message or the response content if a message is not available
     * @param response the HTTP response
     */
    public APIErrorException(final String message, final Response<ResponseBody> response) {
        super(message, response);
    }

    /**
     * Initializes a new instance of the APIErrorException class.
     *
     * @param message the exception message or the response content if a message is not available
     * @param response the HTTP response
     * @param body the deserialized response body
     */
    public APIErrorException(final String message, final Response<ResponseBody> response, final APIError body) {
        super(message, response, body);
    }

    @Override
    public APIError body() {
        return (APIError) super.body();
    }
}