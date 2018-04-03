package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "estado")
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "esta_id")
    private Integer estaId;

    @Getter
    @Setter
    @Column(name = "esta_nome")
    private String estaNome;

    @Getter
    @Setter
    @Column(name = "esta_uf")
    private String estaUf;

    @Getter
    @Setter
    @Column(name = "esta_ibge")
    private Integer estaIbge;

    @Getter
    @Setter
    @Column(name = "esta_ddd")
    private String estaDdd;

    @Getter
    @Setter
    @JoinColumn(name = "esta_pais_id", referencedColumnName = "pais_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pais estaPaisId;

    public Estado() {
    }

    public Estado(Integer estaId) {
        this.estaId = estaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estaId != null ? estaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.estaId == null && other.estaId != null) || (this.estaId != null && !this.estaId.equals(other.estaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Estado[ estaId=" + estaId + " ]";
    }

}
