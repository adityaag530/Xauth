package com.aditya.xauth.service;
/*
 * @author adityagupta
 * @date 22/03/24
 */

import com.aditya.xauth.config.JwtService;
import com.aditya.xauth.dto.AuthResponseDTO;
import com.aditya.xauth.dto.RegisterRequestDTO;
import com.aditya.xauth.model.Role;
import com.aditya.xauth.model.User;
import com.aditya.xauth.respository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager manager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager manager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.manager = manager;
    }

    public AuthResponseDTO register(RegisterRequestDTO request) {
        logger.info("Registration request received for user: {}", request.getEmail());

        var user = User.builder()
                .email(request.getEmail())
                .userName(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        logger.info("User {} successfully registered. JWT token generated.", user.getEmail());
        return AuthResponseDTO.builder()
                .token(jwtToken)
                .build();
    }

    public AuthResponseDTO authenticate(RegisterRequestDTO request) {
        logger.info("Authentication attempt for user: {}", request.getEmail());

        manager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        logger.info("User {} successfully authenticated. JWT token generated.", user.getEmail());
        return AuthResponseDTO.builder()
                .token(jwtToken)
                .build();
    }
}
