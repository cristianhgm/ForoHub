package com.alura.forohub.controller;

import com.alura.forohub.domain.user.User;
import com.alura.forohub.domain.user.UserAuthenticationData;
import com.alura.forohub.infra.security.JWTData;
import com.alura.forohub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public JWTData login(@RequestBody @Valid UserAuthenticationData userAuthenticationData) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                userAuthenticationData.name(),
                userAuthenticationData.password()
        );
        try {
            Authentication authentication = authenticationManager.authenticate(authToken);
            String token = tokenService.generateToken((User) authentication.getPrincipal());
            return new JWTData(token);
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid login credentials", e);
        }
    }
}
