package br.com.sgp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sgp.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer>{

}
