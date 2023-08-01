package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entites.Annonces;

public interface AnnoncesRepository extends JpaRepository<Annonces,Long> {

}
