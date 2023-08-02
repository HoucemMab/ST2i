package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.IntService.IntType_annonceService;
import com.example.demo.Repository.Type_annonceRepository;
import com.example.demo.entites.Type_annonce;

@Service
public class Type_annonceService implements IntType_annonceService {
	
	@Autowired
	private Type_annonceRepository Type_annonceRepository;

	@Override
	public Type_annonce save(Type_annonce Type_annonce) {
		return Type_annonceRepository.save(Type_annonce);
	}

	@Override
	public List<Type_annonce> getListType_annonce() {
		return Type_annonceRepository.findAll();
	}

	@Override
	public Type_annonce getType_annonceById(long id_Type_annonce) {
		return Type_annonceRepository.findById(id_Type_annonce).orElse(null);
	}

	@Override
	public Type_annonce updateType_annonce(Type_annonce Type_annonce, long id_Type_annonce) {
		Type_annonce existingType_annonce = Type_annonceRepository.findById(id_Type_annonce).orElse(null);
		existingType_annonce.setNom_Type(Type_annonce.getNom_Type());
		
		return Type_annonceRepository.save(existingType_annonce);
	}

	@Override
	public void deleteType_annonce(long id_Type_annonce) {
		Type_annonceRepository.deleteById(id_Type_annonce);
		
	}

}
