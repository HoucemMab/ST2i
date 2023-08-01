package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.Service.notationService;
import com.example.demo.entites.notation;

public class notationController {
	  
	@Autowired
	private notationService notationService;
	
	@PostMapping("/addnotation")
	public ResponseEntity<notation> createnotation(@RequestBody notation notation) {
		try {
			notation _notation = notationService.save(notation);
			return new ResponseEntity<>(_notation, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getnotation")
	public ResponseEntity<List<notation>> getAllnotation(@RequestParam(required = false) String note) {
		try {
			List<notation> notation = notationService.getListnotation();
			if (notation.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(notation, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/notation/{id_notation}")
	public ResponseEntity<HttpStatus> deletenotation(@PathVariable("id_notation") long id_notation) {
		try {
			notationService.deletenotation(id_notation);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/notation/{id_notation}")
	public ResponseEntity<notation> updatecommentaires(@PathVariable("id_notation") long id_notation, @RequestBody notation notation) {
		notation notationData = notationService.updatenotation(notation, id_notation);
		if (notationData!=null) {
			return new ResponseEntity<>(notationData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
