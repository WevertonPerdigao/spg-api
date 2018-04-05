package br.com.sgp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sgp.model.Arquivo;

public interface ArquivoRepository extends JpaRepository<Arquivo, Integer>{

}
