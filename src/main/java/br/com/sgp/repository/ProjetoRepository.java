package br.com.sgp.repository;


import br.com.sgp.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


public interface ProjetoRepository extends JpaRepository<Projeto,Integer> {

    @Query("SELECT p FROM Projeto as p join p.equipe k join fetch p.atividades where k.funcId = :funcId")
    List<Projeto> listByFuncionarioId(@Param("funcId") Integer id);
    
    
    @Query("select P from Projeto P left join fetch P.projEmprId emp left join fetch P.projFuncId as func")
    List<Projeto> getTodosProjetos();


	
}
