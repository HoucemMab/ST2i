package com.example.demo.entites;



import java.util.Date;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;




@Table(name = "Acheteur")
@Entity
public class Acheteur {


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@JsonProperty
	private long Id_acheteur;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column (name = "lastName")
    private String lastName;
	
	@Column (name = "mail", unique=true)
    private String mail;
	
	@Column (name = "telephone")
    private String telephone;
	
	@Column(name = "Date_naissance")
    private Date Date_naissance;
	
	@ManyToMany(mappedBy = "acheteurs")
    private List<Annonces> annonces;


	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String FirstName) {
		this.firstName = FirstName;
	}
	


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDate_naissance() {
		return Date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		Date_naissance = date_naissance;
	}
	
	
	

	
	
	

	
    

}
