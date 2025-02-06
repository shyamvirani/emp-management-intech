package com.ems.employeemanagement.exception;

import com.ems.employeemanagement.rest.ResponseStatusEnum;
import com.ems.employeemanagement.rest.RestResponse;
import com.ems.employeemanagement.rest.RestServiceConstants;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public final RestResponse handleDepartmentException(CommonException ex, WebRequest request) {
        RestResponse restResponse = new RestResponse();
        restResponse.getMetadata().setErrorOutcome(ResponseStatusEnum.ERROR.value(), ex.getCause().getMessage(), RestServiceConstants.REST_SERVICE_ERROR_CODE);
        return restResponse;
    }
}
