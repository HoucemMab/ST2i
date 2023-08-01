package com.example.demo.entites;



import java.util.Date;



import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;




@Table (name = "commentaires")
@Entity
public class commentaires {
	   @Id
	   @GeneratedValue (strategy = GenerationType.IDENTITY )
       private long id_commentaires;
	   private long id_commentateur;
	   
	   @Column (name = "nom_commentateur")
       private String nom_commentateur;
	   
	   
	   @Column (name = "contenu")
       private String contenu;
	   
	   @Column (name = "moderation")
       private String moderation;
	   
	   @Column (name = "publie")
       private Boolean publie;
	   
	   @Column (name = "Date_creation")
       private Date Date_creation;
	   
	   @ManyToMany(mappedBy = "comment")
		private List<Annonces> Annonces;

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getModeration() {
		return moderation;
	}

	public void setModeration(String moderation) {
		this.moderation = moderation;
	}
	   
	   
	   
	   
	   
	   


	



   
}
