package com.example.demo.entites;

import java.util.Date;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;




@Table(name = "Annonces")
@Entity
public class Annonces {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long ID;
	@Column(name = "prix")
	private String prix;
	@Column(name = "Titre")
	private String Titre;
	@Column (name = "Date_creation")
	private Date Date_creation;
    @Column (name = "Date_update")
    private Date Date_update;
    @Column(name ="degree")
    private String degree;
    @Column (name = "visible")
    private Boolean visible;
    @Column(name = "vendu")
    private Boolean vendu;
    @Column(name = "Date_expiration")
    private Date Date_expiration;
    
    @ManyToOne
    private Annonceur annonceur;
    
    @ManyToMany
    private List<Acheteur> acheteurs;

    
    @ManyToMany
    private List<video> videos;
    
    @ManyToMany
    private List<image> images;
    
    @ManyToMany
    private List<commentaires> comment;
    
    @ManyToMany
    private List<categorie> categories;
    
    @ManyToMany
    private List<notation> notations;
    
    @ManyToOne
    private Type_annonce type_annonce;

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public String getTitre() {
		return Titre;
	}

	public void setTitre(String titre) {
		Titre = titre;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Boolean getVendu() {
		return vendu;
	}

	public void setVendu(Boolean vendu) {
		this.vendu = vendu;
	}

	
    
    
}
