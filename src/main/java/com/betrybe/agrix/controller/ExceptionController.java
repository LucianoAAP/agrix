package com.betrybe.agrix.controller;

import com.betrybe.agrix.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Exception controller.
 */
@ControllerAdvice
public class ExceptionController {
  @ExceptionHandler({NotFoundException.class})
  public ResponseEntity<String> handleNotFoundException(Exception exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }
  
  @ExceptionHandler({Exception.class})
  public ResponseEntity<String> handleException(Exception exception) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
  }
  
  @ExceptionHandler(Throwable.class)
  public ResponseEntity<String> handleThrowable(Throwable exception) {
    return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(exception.getMessage());
  }
}
