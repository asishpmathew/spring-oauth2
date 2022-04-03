package com.test.auth2.controller;

import com.test.auth2.entity.AuthRequest;
import com.test.auth2.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class WelcomeController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        return "welcome asish";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        } catch (Exception e) {
            throw new Exception("invalid usr/pwd");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
