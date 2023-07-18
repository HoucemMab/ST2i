package com.example.demo.Repository;


import java.util.Objects;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entites.commentaires;

public interface commentairesRepository extends JpaRepository<commentaires, Long> {

	
	
}
