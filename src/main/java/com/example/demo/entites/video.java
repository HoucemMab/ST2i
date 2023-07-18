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
@Table(name = "video")
@Entity
public class video {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private long Id_video;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "alt")
    private String alt;
	
	@Column(name = "groupe")
    private String groupe;
	
	@Column(name = "Date_creation")
    private Date Date_creation;
	
	@ManyToMany(mappedBy = "videos")
	private List<Annonces> Annonces;

	public static Object getvideourl() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
    
}
