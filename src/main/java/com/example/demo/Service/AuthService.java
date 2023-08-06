package com.example.demo.Service;


import com.example.demo.Config.JwtTokenUtil;
import com.example.demo.DTO.AuthRequest;
import com.example.demo.DTO.AuthResponse;
import com.example.demo.Repository.AnnonceurRepository;
import com.example.demo.entites.Annonceur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AnnonceurRepository annonceurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    public Annonceur register(Annonceur annonceur){
        annonceur.setPassword(passwordEncoder.encode(annonceur.getPassword()));
    return this.annonceurRepository.save(annonceur);
    }

    public String login (AuthRequest authRequest){
        System.out.println(authRequest.getMail() +" " + authRequest.getPassword());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getMail(), authRequest.getPassword()));
        } catch (Exception e){
            System.out.println("The exception : "+ e);
        }
var user= annonceurRepository.findAnnonceurByMail(authRequest.getMail()).orElseThrow();
System.out.println(user.toString());
var jwtToken = jwtTokenUtil.generateToken(user.getUsername());
System.out.println("token" + jwtToken);
return  jwtToken;
    }
}
