package com.aditya.xauth.controller;

import com.aditya.xauth.dto.AuthResponseDTO;
import com.aditya.xauth.dto.RegisterRequestDTO;
import com.aditya.xauth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author adityagupta
 * @date 22/03/24
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(
            @RequestBody RegisterRequestDTO request
    ){
        logger.info("ENDPOINT: Inside Register endpoint of controller");
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponseDTO> authenticate(
            @RequestBody RegisterRequestDTO request
    ){
        logger.info("ENDPOINT: Inside authenticate endpoint of controller");
        return ResponseEntity.ok(service.authenticate(request));
    }

}
