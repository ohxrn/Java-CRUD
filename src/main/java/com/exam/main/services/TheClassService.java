package com.exam.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.main.models.TheClass;

import com.exam.main.repositories.TheClassRepo;

@Service
public class TheClassService {

	@Autowired
	private TheClassRepo repo;
	
	public TheClass findById(Long id) {

		Optional<TheClass> result = repo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		
		return null;
	}
	

	public List<TheClass> all() {
		return repo.findAll();
	}
	
	public TheClass update(TheClass theClass) {
		return repo.save(theClass);
	}
	
	public TheClass create(TheClass theClass) {
		return repo.save(theClass);
	}
	
	public void delete(TheClass theClass) {
		repo.delete(theClass);
	}
}