package com.example.demo.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entites.commentaires;

public interface commentairesRepository extends JpaRepository<commentaires, Long> {
	@Query(value = "SELECT c1.nom_commentateur FROM commentaires c1 WHERE c1.id_commentateur = (SELECT MAX(c2.id_commentateur) FROM commentaires c2 WHERE c2.id_commentateur < :id_nom_commentateur)", nativeQuery = true)
	String findNomCommentateurAbove(@Param("id_nom_commentateur") Long id_nom_commentateur);
	

	
	
}
