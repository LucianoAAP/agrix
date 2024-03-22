package com.betrybe.agrix.dto;

import com.betrybe.agrix.model.enums.Role;

/**
 * Record representing a person.
 */
public record PersonDto(long id, String username, Role role) {

}
