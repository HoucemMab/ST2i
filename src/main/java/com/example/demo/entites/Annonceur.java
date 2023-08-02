package com.example.demo.entites;




import java.util.Date;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Annonceur {
	
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id_annonceur;

	    @Column(name = "first_name")
	    public  String firstName;

	    @Column(name = "last_name")
	    private String lastName;

	    @Column(name = "mail")
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
