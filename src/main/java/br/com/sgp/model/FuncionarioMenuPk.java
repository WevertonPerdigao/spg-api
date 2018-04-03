package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FuncionarioMenuPk implements Serializable {

    @Getter
    @Setter
    @Column(name = "fume_func_id", nullable = false)
    private Integer fumeFuncId;

    @Getter
    @Setter
    @Column(name = "fume_menu_id", nullable = false)
    private Integer fumeMenuId;

    public FuncionarioMenuPk() {
    }

}
