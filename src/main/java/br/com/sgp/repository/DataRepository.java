package br.com.sgp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;



public class DataRepository<T> {

	@Autowired
	JpaRepository<T, Integer> repository;

	public JpaRepository<T, Integer> getRepository() {
		return repository;
	}

	public void setRepository(JpaRepository<T, Integer> repository) {
		this.repository = repository;
	}
	
	
	
}
