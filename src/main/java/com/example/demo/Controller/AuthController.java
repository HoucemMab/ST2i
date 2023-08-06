package com.example.demo.Controller;

import com.example.demo.DTO.AuthRequest;
import com.example.demo.Config.JwtTokenUtil;
import com.example.demo.DTO.AuthResponse;
import com.example.demo.Service.AuthService;
import com.example.demo.entites.Annonceur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<Annonceur> register(@RequestBody Annonceur annonceur){
        return ResponseEntity.ok(this.authService.register(annonceur));
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        return  ResponseEntity.ok(this.authService.login(authRequest));
    }
}

