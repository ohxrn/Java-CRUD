package com.exam.main.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.exam.main.models.TheClass;

@Repository
public interface TheClassRepo extends CrudRepository<TheClass, Long> {

	List<TheClass> findAll();
}