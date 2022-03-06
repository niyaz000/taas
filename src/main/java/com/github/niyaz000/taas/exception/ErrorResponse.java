package com.github.niyaz000.taas.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class ErrorResponse {

  public ErrorResponse(String message, String description) {
    this(message, description, new ArrayList<>());
  }

  private String message;
  private String description;
  private Collection<Error> errors;

  public ErrorResponse(String message, String description, Collection<Error> errors) {
    this.message = message;
    this.description = description;
    this.errors = errors;
  }

  public void addError(Error error) {
    errors.add(error);
  }


  @Data
  public static class Error {

    private String field;

    private String code;

    private String description;

    public Error(String field, String code, String description) {
      this.field = field;
      this.code = code;
      this.description = description;
    }

  }
}
