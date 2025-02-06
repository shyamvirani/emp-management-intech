package com.ems.employeemanagement.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author dolyt
 * @create 20-01-2021 14:26
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Outcome {

    private Integer status;

    private String type;

    private String message;

    private Integer code;

    /**
     * Sets success outcome.
     */
    public void setSuccessOutcome() {
        this.status = ResponseStatusEnum.OK.value();
        this.type = ResponseTypeEnum.OK.value();
        this.message = RestServiceConstants.REST_SERVICE_SUCCESS_MSG;
        this.code = RestServiceConstants.REST_SERVICE_SUCCESS_CODE;
    }

    /**
     * Sets error outcome.
     *
     * @param e the e
     */
    public void setErrorOutcome(Exception e) {
        this.status = ResponseStatusEnum.ERROR.value();
        this.type = ResponseTypeEnum.ERROR.value();
        this.message = e.getMessage();
        this.code = RestServiceConstants.REST_SERVICE_ERROR_CODE;
    }
}
