package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "menu_perfil")
public class MenuPerfil {


    @EmbeddedId
    private MenuPerfilPk menuPerfilPk;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "mepe_perf_id", insertable = false, updatable = false, nullable = false)
    private Perfil perfil;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "mepe_menu_id", insertable = false, updatable = false, nullable = false)
    private Menu menu;

    public MenuPerfil() {

    }
}
