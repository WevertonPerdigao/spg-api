package br.com.sgp.repository;

import br.com.sgp.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("SELECT f FROM Funcionario as f where f.funcEmail= :email")
    Funcionario findByEmail(@Param("email") String email);
}
