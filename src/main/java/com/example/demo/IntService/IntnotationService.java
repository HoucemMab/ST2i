package com.example.demo.IntService;

import java.util.List;

import com.example.demo.entites.notation;

public interface IntnotationService {
	notation save(notation notation);

	List<notation> getListnotation();

	notation getnotationById(long id_notation);

	notation updatenotation(notation notation, long id_notation);

	void deletenotation(long id_notation);



}
