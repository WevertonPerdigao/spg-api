package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "pais")
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pais_id")
    private Integer paisId;

    @Getter
    @Setter
    @Column(name = "pais_nome")
    private String paisNome;

    @Getter
    @Setter
    @Column(name = "pais_nome_pt")
    private String paisNomePt;

    @Getter
    @Setter
    @Column(name = "pais_sigla")
    private String paisSigla;

    @Getter
    @Setter
    @Column(name = "pais_bacen")
    private Integer paisBacen;

    public Pais() {
    }

    public Pais(Integer paisId) {
        this.paisId = paisId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paisId != null ? paisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.paisId == null && other.paisId != null) || (this.paisId != null && !this.paisId.equals(other.paisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pais[ paisId=" + paisId + " ]";
    }

}
