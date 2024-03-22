package com.aditya.xauth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @author adityagupta
 * @date 22/03/24
 */

/**
 *This class represents the request body object used in argument of authcontroller class endpoints.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {
    private String username;
    private String email;
    private String password;
}
