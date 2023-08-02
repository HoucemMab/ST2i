package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.categorieService;
import com.example.demo.entites.categorie;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/api")
public class categorieController {
	
	@Autowired
	private categorieService categorieServices;

	@PostMapping("/addcategorie")
	public ResponseEntity<categorie> createcommentaires(@RequestBody categorie categorie) {
		try {
			categorie _categorie = categorieServices.save(categorie);
			return new ResponseEntity<>(_categorie, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getcategorie")
	public ResponseEntity<List<categorie>> getAllcategorieServices(@RequestParam(required = false) String Nom) {
		try {
			List<categorie> categorie = categorieServices.getListcategorie();
			if (categorie.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(categorie, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/categorie/{id_categorie}")
	public ResponseEntity<HttpStatus> deletecategorie(@PathVariable("id_categorie") long id_categorie) {
		try {
			categorieServices.deletecategorie(id_categorie);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/categorie/{id_categorie}")
	public ResponseEntity<categorie> updatecategorie(@PathVariable("id_categorie") long id_categorie, @RequestBody categorie categorie) {
		categorie categorieData = categorieServices.updatecategorie(categorie, id_categorie);
		if (categorieData!=null) {
			return new ResponseEntity<>(categorieData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


}
