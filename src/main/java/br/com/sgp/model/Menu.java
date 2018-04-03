package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Integer menuId;

    @Getter
    @Setter
    @Column(name = "menu_nome")
    private String menuNome;

    @Getter
    @Setter
    @Column(name = "menu_descricao")
    private String menuDescricao;

    @Getter
    @Setter
    @Column(name = "menu_url")
    private String menuUrl;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "menu_sequencia")
    private int menuSequencia;

    @Getter
    @Setter
    @JoinColumn(name = "menu_pai_id",   referencedColumnName = "menu_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Menu menuPaiId;

    public Menu() {
    }

    public Menu(Integer menuId) {
        this.menuId = menuId;
    }

    public Menu(Integer menuId, int menuSequencia) {
        this.menuId = menuId;
        this.menuSequencia = menuSequencia;
    }

    @Override
    public String toString() {
        return "model.Menu[ menuId=" + menuId + " ]";
    }

}
