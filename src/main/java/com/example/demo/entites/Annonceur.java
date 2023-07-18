package com.example.demo.entites;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Annonceur")
public class Annonceur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_annonceur;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mail")
    private String mail;

    @Column(name = "password")
    private String password;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "date_naissance")
    private Date dateNaissance;
    
    @OneToMany(mappedBy="annonceur")
    private List<Annonces> Annonces= new ArrayList<>();

	public Annonceur getNom() {
		return null;
	}

	public Annonceur getEmail() {
		return null;
	}

    
}
