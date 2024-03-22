package com.betrybe.agrix.dto;

import com.betrybe.agrix.model.enums.Role;

/**
 * Record representing person creation.
 */
public record PersonCreationDto(String username, String password, Role role) {

}
