package com.example.demo.Service;


import com.example.demo.Repository.AnnonceurRepository;
import com.example.demo.entites.Annonceur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private AnnonceurRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        // Implement loading user details from the repository
        Optional<Annonceur> user = userRepository.findAnnonceurByMail(mail);
        if (user.isPresent()) {
            throw new UsernameNotFoundException("User not found with username: " + mail);
        }

        return new org.springframework.security.core.userdetails.User(
                user.get().getMail(),
                user.get().getPassword(),
                Collections.emptyList() // You may add user roles here
        );
    }
}
