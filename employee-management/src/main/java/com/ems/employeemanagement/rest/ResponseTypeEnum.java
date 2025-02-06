package com.ems.employeemanagement.rest;

import lombok.AllArgsConstructor;

/**
 * @Author dolyt
 * @create 20-01-2021 14:26
 */
@AllArgsConstructor
public enum ResponseTypeEnum {

    /**
     * Ok response type enum.
     */
    OK("OK"),

    /**
     * Error response type enum.
     */
    ERROR("ERROR");

    /**
     * The Response type.
     */
    private String responseType;


    /**
     * Value string.
     *
     * @return the string
     */
    public String value() {
        return responseType;
    }

}
