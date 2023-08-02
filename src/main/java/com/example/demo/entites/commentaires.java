package com.example.demo.entites;



import java.util.Date;



import java.util.List;

import jakarta.persistence.*;


@Table (name = "commentaires")
@Entity
public class commentaires {
	   @Id
	   @GeneratedValue (strategy = GenerationType.IDENTITY )
       private long id_commentaires;


	@Column (name = "nom_commentateur")
	private long id_commentateur;
	   

	   
	   
	   @Column (name = "contenu")
       private String contenu;
	   
	   @Column (name = "moderation")
       private String moderation;
	   
	   @Column (name = "publie")
       private Boolean publie;
	   
	   @Column (name = "Date_creation")
       private Date Date_creation;


	   @ManyToOne()
	   @JoinColumn(name = "annonce_id")
	   private Annonces Annonces;




	public com.example.demo.entites.Annonces getAnnonces() {
		return Annonces;
	}

	public void setAnnonces(com.example.demo.entites.Annonces annonces) {
		Annonces = annonces;
	}

	public long getId_commentaires() {
		return id_commentaires;
	}

	public void setId_commentaires(long id_commentaires) {
		this.id_commentaires = id_commentaires;
	}

	public long getId_commentateur() {
		return id_commentateur;
	}

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
