package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "projeto_equipe")
public class ProjetoEquipe {


    @EmbeddedId
    private ProjetoEquipePk projetoEquipePk;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "preq_proj_id", insertable = false, updatable = false, nullable = false)
    private Projeto projeto;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "preq_func_id", insertable = false, updatable = false, nullable = false)
    private Funcionario funcionario;

    public ProjetoEquipe() {

    }
}
