package edu.cnm.deepdive.server.controller.exception;

import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

  /**
   * Throws an exception if the search term is too short.
   */
  @ExceptionHandler(SearchTermTooShortException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Search term too short")
  public void tooShort() {}

  /**
   * Throws an exception if no resources are found.
   */
  @ExceptionHandler(NoSuchElementException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  public void notFound() {}

  /**
   * Throws an exception if the request is invalid.
   */
  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid request content or parameters")
  public void badRequest() {}

}
