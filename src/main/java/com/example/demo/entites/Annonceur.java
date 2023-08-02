package com.example.demo.entites;




import java.util.Date;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
@Table(name = "Annonceur")

@Entity

public class Annonceur {
	
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		@JsonProperty

		private Long id_annonceur;

	    @Column(name = "first_name")
	    public  String firstName;

	    @Column(name = "last_name")
	    private String lastName;

	    @Column(name = "mail",unique = true)
	    public  String mail;

	    @Column(name = "password")
	    private String password;

	    @Column(name = "telephone")
	    private String telephone;
	    
	    @Temporal(TemporalType.DATE)
	    @Column(name = "date_naissance")
	    private Date dateNaissance;


		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
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

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

		public Date getDateNaissance() {
			return dateNaissance;
		}

		public void setDateNaissance(Date dateNaissance) {
			this.dateNaissance = dateNaissance;
		}

		public Annonceur(long id_annonceur, String firstName, String lastName, String mail, String password,
				String telephone, Date dateNaissance) {
			super();
			this.id_annonceur = id_annonceur;
			this.firstName = firstName;
			this.lastName = lastName;
			this.mail = mail;
			this.password = password;
			this.telephone = telephone;
			this.dateNaissance = dateNaissance;
		}

		public Annonceur() {
			super();
		}
		
		
		
		
		
	    
	    
}
