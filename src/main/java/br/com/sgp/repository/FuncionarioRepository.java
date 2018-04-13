package br.com.sgp.repository;

import br.com.sgp.model.Funcionario;
import br.com.sgp.model.Perfil;
import br.com.sgp.model.Provisao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("SELECT f FROM Funcionario as f where f.funcEmail= :email")
    Funcionario findByEmail(@Param("email") String email);

    @Query("SELECT p FROM Provisao as p join p.funcionario as f where f.funcId= :id")
    List<Provisao> getProvisoes(@Param("id") Integer codigo);

    @Query("SELECT perfil FROM Funcionario as p join p.perfil perfil where p.funcId= :id")
	Perfil getPerfilFuncionario(@Param("id") Integer id);
}
