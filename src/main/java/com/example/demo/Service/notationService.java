package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.notationRepository;
import com.example.demo.IntService.IntnotationService;
import com.example.demo.entites.notation;


@Service
public class notationService implements IntnotationService {
	
	@Autowired
	private notationRepository notationRepository;

	@Override
	public notation save(notation notation) {
		return notationRepository.save(notation);
	}

	@Override
	public List<notation> getListnotation() {
		return notationRepository.findAll();
	}

	@Override
	public notation getnotationById(long id_notation) {
		return notationRepository.findById(id_notation).orElse(null) ;
	}

	@Override
	public notation updatenotation(notation notation, long id_notation) {
		 notation existingnotation = notationRepository.findById(id_notation).orElse(null);
		 existingnotation.setNote(notation.getNote());
		return notationRepository.save(existingnotation);
	}

	@Override
	public void deletenotation(long id_notation) {
		notationRepository.deleteById(id_notation);
		
	}

}
