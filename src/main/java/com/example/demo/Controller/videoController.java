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

import com.example.demo.Service.videoService;
import com.example.demo.entites.video;

@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequestMapping("/api")
public class videoController {
	@Autowired
	private videoService videoService;

	@PostMapping("/addvideo")
	public ResponseEntity<video> createvideo(@RequestBody video video) {
		try {
			video _video = videoService.save(video);
			return new ResponseEntity<>(_video, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
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
