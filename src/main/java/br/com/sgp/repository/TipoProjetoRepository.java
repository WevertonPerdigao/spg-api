package br.com.sgp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sgp.model.Projeto;
import br.com.sgp.model.TipoProjeto;

public interface TipoProjetoRepository extends JpaRepository<TipoProjeto,Integer> {

	
	
}
