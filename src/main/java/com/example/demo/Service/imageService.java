package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.IntService.IntimageService;
import com.example.demo.Repository.imageRepository;
import com.example.demo.entites.image;

@Service
public class imageService implements IntimageService {
	@Autowired
	private imageRepository imageRepository;

	@Override
	public image save(image image) {
		return imageRepository.save(image);
	}

	@Override
	public List<image> getListimage() {
		return imageRepository.findAll();
	}

	@Override
	public image getimageById(long id_image) {
		return imageRepository.findById(id_image).orElse(null);
	}

	@Override
	public image updateimage(image image, long id_image) {
		image existingimage = imageRepository.findById(id_image).orElse(null);
		existingimage.setUrl(image.getUrl());
		existingimage.setGroupe(image.getGroupe());
		
		return imageRepository.save(existingimage);
	}

	@Override
	public void deleteimage(long id_image) {
		imageRepository.deleteById(id_image);
		
	}


	

}
