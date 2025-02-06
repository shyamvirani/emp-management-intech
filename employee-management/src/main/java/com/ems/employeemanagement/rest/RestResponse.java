package com.ems.employeemanagement.rest;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @Author dolyt
 * @create 20-01-2021 14:26
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RestResponse extends ServiceResponse {

    public RestResponse() {
        super();
    }

    /**
     * The Response data.
     */
    Object responseData;

    /**
     * Gets response data.
     *
     * @return the response data
     */
    public Object getResponseData() {
        return responseData;
    }

    /**
     * Sets response data.
     *
     * @param responseData the response data
     */
    public void setResponseData(Object responseData) {
        this.responseData = responseData;
    }

    @Override
    public String toString() {
        return "RestResponse{" +
                "responseData=" + responseData +
                '}';
    }
}
