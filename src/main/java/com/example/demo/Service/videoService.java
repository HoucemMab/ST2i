package com.example.demo.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.IntService.IntvideoService;
import com.example.demo.entites.video;
import com.example.demo.Repository.videoRepository;

@Service
public class videoService implements IntvideoService {
	
	@Autowired 
	private videoRepository videoRepository;

	@Override
	public video save(video video) {
		return videoRepository.save(video);
	}

	@Override
	public List<video> getListvideo() {
		return videoRepository.findAll();
	}

	@Override
	public video getvideoById(long id_video) {
		return videoRepository.findById(id_video).orElse(null);
	}

	@Override
	public video updatevideo(video video, long id_video) {
		video existingvideo = videoRepository.findById(id_video).orElse(null);
		existingvideo.setAlt(video.getAlt());
		existingvideo.setGroupe(video.getGroupe());
		existingvideo.setUrl(video.getUrl());
		return videoRepository.save(existingvideo);
	}

	@Override
	public void deletevideo(long id_video) {
		videoRepository.deleteById(id_video);
		
	}

}
