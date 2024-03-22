package com.betrybe.agrix.exception;

/**
 * Not found exception.
 */
public class NotFoundException extends Exception {

  private static final long serialVersionUID = -144652996401275521L;
  
  public NotFoundException(String message) {
    super(message);
  }

}
