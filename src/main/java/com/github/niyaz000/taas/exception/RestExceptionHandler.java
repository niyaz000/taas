package com.github.niyaz000.taas.exception;

import com.github.niyaz000.taas.constant.ErrorConstant;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  public @ResponseBody ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
                                                      HttpHeaders headers,
                                                      HttpStatus status,
                                                      WebRequest webRequest) {
    return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(buildErrorResponse(e.getBindingResult().getFieldErrors()));
  }

  private ErrorResponse buildErrorResponse(List<FieldError> errors) {
    var errorResponse = new ErrorResponse(ErrorConstant.VALIDATION_FAILED_MSG, ErrorConstant.VALIDATION_FAILED_DESCRIPTION);
    errors.forEach(fieldError -> errorResponse.addError(new ErrorResponse.Error(fieldError.getField(), fieldError.getCode(), fieldError.getDefaultMessage())));
    return errorResponse;
  }
}
