package com.ems.employeemanagement.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


/**
 * @Author dolyt
 * @create 20-01-2021 14:26
 */
@JsonInclude(Include.NON_EMPTY)
public class ServiceResponse {

    private Metadata metadata;

    public ServiceResponse() {
        this.metadata = new Metadata();
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "ServiceResponse{" +
                "metadata=" + metadata +
                '}';
    }
}
