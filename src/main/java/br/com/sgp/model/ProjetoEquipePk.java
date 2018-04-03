package br.com.sgp.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProjetoEquipePk implements Serializable {

    @Getter
    @Setter
    @Column(name = "preq_proj_id", nullable = false)
    private Integer projId;

    @Getter
    @Setter
    @Column(name = "preq_func_id", nullable = false)
    private Integer funcId;

    public ProjetoEquipePk() {
    }

}
