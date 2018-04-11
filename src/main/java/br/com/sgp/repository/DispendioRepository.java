package br.com.sgp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sgp.model.Dispendio;
import br.com.sgp.model.DispendioAnexo;

public interface DispendioRepository extends JpaRepository<Dispendio, Integer>{

	@Query("select A from DispendioAnexo as A where A.id = :codigo")
	DispendioAnexo getAnexo(@Param("codigo") Integer id);

}
