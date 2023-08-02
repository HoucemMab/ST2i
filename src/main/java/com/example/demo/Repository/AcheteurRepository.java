package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entites.Acheteur;

import java.util.Optional;

public interface AcheteurRepository extends JpaRepository<Acheteur,Long> {
 Optional<Acheteur> findAcheteurByMail(String mail);
}
