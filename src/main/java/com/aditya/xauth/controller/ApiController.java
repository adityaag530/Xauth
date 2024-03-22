package com.aditya.xauth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author adityagupta
 * @date 22/03/24
 */
@RestController
@RequestMapping("/api/v1")
public class ApiController {

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);
    @GetMapping("/public/example")
    public ResponseEntity<String> publicEndpoint() {
        logger.info("ENDPOINT: Inside public endpoint of controller");
        return ResponseEntity.ok("This is a public endpoint.");
    }

    @GetMapping("/private/example")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> privateEndpoint() {
        logger.info("ENDPOINT: Inside private endpoint of controller");
        return ResponseEntity.ok("This is a private endpoint accessible only to authenticated users with ROLE_USER role.");
    }
}
