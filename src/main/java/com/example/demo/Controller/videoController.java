package com.example.demo.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import com.example.demo.Repository.videoRepository;
import com.example.demo.Service.AnnoncesService;
import com.example.demo.entites.Annonces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Service.videoService;
import com.example.demo.entites.video;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.CannotProceedException;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/api")
public class videoController {
	@Autowired
	private videoService videoService;

	@Autowired
	private com.example.demo.Repository.videoRepository videoRepository;
	@Autowired
	private AnnoncesService annoncesService;

	@Value("${spring.servlet.multipart.location}")
	private String uploadDir;

	private final List<String> allowedVideoTypes = Arrays.asList(
			"video/mp4",
			"video/avi",
			"video/mpeg"
	);

	@PostMapping("/{annonceId}/uploadVideo")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file , @ModelAttribute video vd, @PathVariable Long annonceId ) throws CannotProceedException {
		System.out.println("java.io.tmpdir: " + annonceId);

		try {
			// Check if the uploaded file is an image

			if (!allowedVideoTypes.contains(file.getContentType())) {
				return new ResponseEntity<>("Only image files (mp4, avi, mpeg) are allowed.", HttpStatus.BAD_REQUEST);
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
			vd.setUrl(imageurl);
			vd.setAnnonces(annonces);
			vd.setDate_creation(new Date());
			vd.setAlt(fileName);
			videoRepository.save(vd);

			return new ResponseEntity<>("Video uploaded successfully!", HttpStatus.OK);
		} catch (IOException e) {
			System.out.println(e);
			return new ResponseEntity<>("Failed to upload the video.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



	@GetMapping("/getvideo")
	public ResponseEntity<List<video>> getAllvideo(@RequestParam(required = false) String url) {
		try {
			List<video> video = videoService.getListvideo();
			if (video.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(video, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/video/{id_video}")
	public ResponseEntity<HttpStatus> deletevideo(@PathVariable("id_video") long id_video) {
		try {
			videoService.deletevideo(id_video);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/video/{id_video}")
	public ResponseEntity<video> updatevideo(@PathVariable("id_video") long id_video, @RequestBody video video) {
		video videoData = videoService.updatevideo(video, id_video);
		if (videoData!=null) {
			return new ResponseEntity<>(videoData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


}
