package com.aditya.xauth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @author adityagupta
 * @date 22/03/24
 */

/*
This class represents the response message returned by authcontroller class endpoints.
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponseDTO {
    private String token;
}
