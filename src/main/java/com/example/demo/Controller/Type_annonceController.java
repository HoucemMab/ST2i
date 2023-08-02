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

import com.example.demo.Service.Type_annonceService;
import com.example.demo.entites.Type_annonce;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/api")
public class Type_annonceController {
	
	@Autowired
	private Type_annonceService Type_annonceService;

	@PostMapping("/addType_annonce")
	public ResponseEntity<Type_annonce> createType_annonce(@RequestBody Type_annonce Type_annonce) {
		try {
			Type_annonce _Type_annonce = Type_annonceService.save(Type_annonce);
			return new ResponseEntity<>(_Type_annonce, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getType_annonce")
	public ResponseEntity<List<Type_annonce>> getAllType_annonce(@RequestParam(required = false) String nom_Type) {
		try {
			List<Type_annonce> Type_annonce = Type_annonceService.getListType_annonce();
			if (Type_annonce.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Type_annonce, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/Type_annonce/{id_Type_annonce}")
	public ResponseEntity<HttpStatus> deleteType_annonce(@PathVariable("id_Type_annonce") long id_Type_annonce) {
		try {
			Type_annonceService.deleteType_annonce(id_Type_annonce);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/Type_annonce/{id_Type_annonce}")
	public ResponseEntity<Type_annonce> updateType_annonce(@PathVariable("id_Type_annonce") long id_Type_annonce, @RequestBody Type_annonce Type_annonce) {
		Type_annonce Type_annonceData = Type_annonceService.updateType_annonce(Type_annonce, id_Type_annonce);
		if (Type_annonceData!=null) {
			return new ResponseEntity<>(Type_annonceData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
