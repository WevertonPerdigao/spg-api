package br.com.sgp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sgp.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade,Integer>
{

	@Query("select c from Cidade as c where c.cidaEstaId.id = :id")
	public List<Cidade> getCidadesByEstado(@Param("id") Integer param);
}
