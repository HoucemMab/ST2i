package com.example.demo.IntService;

import java.util.List;

import com.example.demo.entites.Type_annonce;

public interface IntType_annonceService {

	Type_annonce save(Type_annonce Type_annonce);

	List<Type_annonce> getListType_annonce();

	Type_annonce getType_annonceById(long id_Type_annonce);

	Type_annonce updateType_annonce(Type_annonce Type_annonce, long id_Type_annonce);

	void deleteType_annonce(long id_Type_annonce);

}
