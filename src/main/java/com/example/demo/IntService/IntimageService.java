package com.example.demo.IntService;

import java.util.List;

import com.example.demo.entites.image;

public interface IntimageService {
	
	image save(image image);

	List<image> getListimage();

	image getimageById(long id_image);

	image updateimage(image image, long id_image);

	void deleteimage(long id_image);

}
