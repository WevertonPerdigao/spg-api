package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "funcionario_menu")
@Getter
@Setter
public class FuncionarioMenu {


    @EmbeddedId
    private FuncionarioMenuPk funcionarioMenuPk;

    @ManyToOne
    @JoinColumn(name = "fume_func_id", insertable = false, updatable = false, nullable = false)
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "fume_menu_id", insertable = false, updatable = false, nullable = false)
    private Menu menu;

    public FuncionarioMenu() {

    }
}
