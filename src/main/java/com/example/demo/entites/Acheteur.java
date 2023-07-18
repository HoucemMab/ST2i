package com.example.demo.entites;



import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

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
@Table(name = "Acheteur")
@Entity
public class Acheteur {


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long Id_acheteur;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column (name = "lastName")
    private String lastName;
	
	@Column (name = "mail")
    private String mail;
	
	@Column (name = "telephone")
    private String telephone;
	
	@Column(name = "Date_naissance")
    private Date Date_naissance;
	
	@ManyToMany(mappedBy = "acheteurs")
    private List<Annonces> annonces;

	public Object getAcheteurfirstName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAcheteurfirstName(Object acheteurfirstName) {
		// TODO Auto-generated method stub
		
	}

	public String getAcheteurmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAcheteurtelephone() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAcheteurtelephone(String acheteurtelephone) {
		// TODO Auto-generated method stub
		
	}

	public void setAcheteurmail(String acheteurmail) {
		// TODO Auto-generated method stub
		
	}
	
	

	
    

}
