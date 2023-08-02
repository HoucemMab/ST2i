package com.example.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entites.Annonceur;

import java.util.Optional;

public interface AnnonceurRepository extends JpaRepository<Annonceur,Long> {
Optional<Annonceur> findAnnonceurByMail( String mail);
}
