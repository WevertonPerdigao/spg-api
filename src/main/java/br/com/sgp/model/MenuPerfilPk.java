package br.com.sgp.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MenuPerfilPk implements Serializable {

    @Getter
    @Setter
    @Column(name = "mepe_perf_id", nullable = false)
    private Integer mepePerfId;

    @Getter
    @Setter
    @Column(name = "mepe_menu_id", nullable = false)
    private Integer mepeMenuId;

    public MenuPerfilPk() {
    }

}
