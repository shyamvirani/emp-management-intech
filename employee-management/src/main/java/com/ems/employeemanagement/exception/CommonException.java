package com.ems.employeemanagement.exception;

public class CommonException extends Exception {

    public CommonException(String message) {
        super("Delete Department", new Throwable(message));
    }

}
