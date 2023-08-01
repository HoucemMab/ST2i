package com.example.demo.IntService;

import java.util.List;

import com.example.demo.entites.video;

public interface IntvideoService {
	
	video save(video video);

	List<video> getListvideo();

	video getvideoById(long id_video);

	video updatevideo(video video, long id_video);

	void deletevideo(long id_video);


}
