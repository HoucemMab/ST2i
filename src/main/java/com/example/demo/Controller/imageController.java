package com.example.demo.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.Repository.imageRepository;
import com.example.demo.Service.AnnoncesService;
import com.example.demo.entites.Annonces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Service.imageService;
import com.example.demo.entites.image;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.CannotProceedException;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/api")
public class imageController {
	
	@Autowired
	private imageService imageService;
	@Autowired
	private com.example.demo.Repository.imageRepository imageRepository;
@Autowired
private AnnoncesService annoncesService;

	@Value("${spring.servlet.multipart.location}")
	private String uploadDir;

	private final List<String> allowedImageTypes = Arrays.asList(
			"image/jpeg",
			"image/png",
			"image/gif"
	);

	@PostMapping("/{annonceId}/image-upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file ,@ModelAttribute image image,@PathVariable Long annonceId ) throws CannotProceedException {
		System.out.println("java.io.tmpdir: " + annonceId);

		try {
			// Check if the uploaded file is an image

			if (!allowedImageTypes.contains(file.getContentType())) {
				return new ResponseEntity<>("Only image files (JPEG, PNG, GIF) are allowed.", HttpStatus.BAD_REQUEST);
			}
			Annonces annonces = annoncesService.getAnnoncesById(annonceId);
			if(annonces==null){
				throw new CannotProceedException("Annonce Not Found");
			}

			// Generate a unique file name
			String fileName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
			File destFile = new File(uploadDir + File.separator + fileName);

			// Save the file to the local storage
			file.transferTo(destFile);

			String imageurl = uploadDir + fileName;
			image.setUrl(imageurl);
			image.setAnnonces(annonces);
			image.setDate_creation(new Date());
			image.setAlt(fileName);
			imageRepository.save(image);

			return new ResponseEntity<>("Image uploaded successfully!", HttpStatus.OK);
		} catch (IOException e) {
			System.out.println(e);
			return new ResponseEntity<>("Failed to upload the image.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/get-images")
	public List<image> getAllImages(){
		return imageService.getListimage();
	}
	@GetMapping("/image/{id}")
	public image getImageById(@PathVariable Long id){
		return imageService.getimageById(id);
	}
}
