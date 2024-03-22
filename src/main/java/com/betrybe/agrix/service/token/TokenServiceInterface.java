package com.betrybe.agrix.service.token;

/**
 * Interface for token service class.
 */
public interface TokenServiceInterface {

  String generateToken(String username);

  String validateToken(String token);

}
