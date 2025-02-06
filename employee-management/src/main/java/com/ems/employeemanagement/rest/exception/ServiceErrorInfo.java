package com.ems.employeemanagement.rest.exception;

import lombok.Data;

/**
 * @Author dolyt
 * @create 20-01-2021 14:26
 */
@Data
public class ServiceErrorInfo {

    private String errorMessage;
    private Integer errorCode;



    @Override
    public String toString() {
        return "ServiceErrorInfo{" +
                "errorMessage='" + errorMessage + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }
}
