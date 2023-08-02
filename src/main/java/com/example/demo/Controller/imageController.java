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

import com.example.demo.Service.imageService;
import com.example.demo.entites.image;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/api")
public class imageController {
	
	@Autowired
	private imageService imageService;
	
	@PostMapping("/addimage")
	public ResponseEntity<image> createcommentaires(@RequestBody image image) {
		try {
			image images = imageService.save(image);
			return new ResponseEntity<>(images, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getimage")
	public ResponseEntity<List<image>> getAllimage(@RequestParam(required = false) String url) {
		try {
			List<image> images = imageService.getListimage();
			if (images.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(images, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/image/{id_image}")
	public ResponseEntity<HttpStatus> deleteimage(@PathVariable("id_image") long id_image) {
		try {
			imageService.deleteimage(id_image);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/image/{id_image}")
	public ResponseEntity<image> updateimage(@PathVariable("id_image") long id_image, @RequestBody image image) {
		image imageData = imageService.updateimage(image, id_image);
		if (imageData!=null) {
			return new ResponseEntity<>(imageData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
