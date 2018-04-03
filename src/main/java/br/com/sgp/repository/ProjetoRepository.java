package br.com.sgp.repository;

import br.com.sgp.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

    @Query("SELECT pe.projeto FROM ProjetoEquipe as pe  where pe.projetoEquipePk.funcId = :funcId")
    List<Projeto> listByFuncionarioId(@Param("funcId") Integer id);
}
