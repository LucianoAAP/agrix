package com.betrybe.agrix.security;

import com.betrybe.agrix.service.staff.PersonServiceInterface;
import com.betrybe.agrix.service.token.TokenServiceInterface;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * JWT filter.
 */
@Component
public class JwtFilter extends OncePerRequestFilter {
  @Autowired
  private TokenServiceInterface tokenService;
  @Autowired
  private PersonServiceInterface personService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    Optional<String> token = extractToken(request);
    if (token.isPresent()) {
      String subject = tokenService.validateToken(token.get());
      UserDetails userDetails = personService.loadUserByUsername(subject);
      UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
          userDetails, null, userDetails.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication(authentication);
    }
    filterChain.doFilter(request, response);
  }

  private Optional<String> extractToken(HttpServletRequest request) {
    String authHeader = request.getHeader("Authorization");
    if (authHeader == null) {
      return Optional.empty();
    }
    return Optional.of(authHeader.replace("Bearer ", ""));
  }
}
