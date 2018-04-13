package br.com.sgp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sgp.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer>{

	@Query("select P from Perfil as P where P.perfNome LIKE :text%")
	List<Perfil> findLike(@Param("text") String text);

}
