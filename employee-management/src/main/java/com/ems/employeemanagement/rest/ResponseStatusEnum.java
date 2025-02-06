package com.ems.employeemanagement.rest;


/**
 * @Author dolyt
 * @create 20-01-2021 14:26
 */
public enum ResponseStatusEnum {

    /**
     * Ok response type enum.
     */
    OK(200),

    /**
     * Error response type enum.
     */
    ERROR(409),

    RECORD_NOT_FOUND(404),
    USER_TASK_NOT_FOUND(422),

    /**
     * Error response type enum.
     */
    INTERNAL_SERVER_ERROR(500);

    /**
     * The Response type.
     */
    private Integer responseType;

    ResponseStatusEnum(Integer responseType) {
        this.responseType = responseType;
    }

    /**
     * Value string.
     *
     * @return the string
     */
    public Integer value() {
        return responseType;
    }

}
