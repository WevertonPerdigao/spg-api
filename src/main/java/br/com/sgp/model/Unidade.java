package br.com.sgp.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "unidade")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Unidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unid_id")
    private Integer unidId;

    @Basic(optional = false)
    @Column(name = "unid_nome")
    private String unidNome;

    public Unidade() {
    }

    public Unidade(Integer unidId) {
        this.unidId = unidId;
    }

    public Unidade(Integer unidId, String unidNome) {
        this.unidId = unidId;
        this.unidNome = unidNome;
    }

}
