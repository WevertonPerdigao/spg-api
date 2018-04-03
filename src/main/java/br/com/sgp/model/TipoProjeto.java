package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "tipo_projeto")
public class TipoProjeto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipr_id")
    private Integer tiprId;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "tipr_nome")
    private String tiprNome;

    public TipoProjeto() {
    }

    public TipoProjeto(Integer tiprId) {
        this.tiprId = tiprId;
    }

    public TipoProjeto(Integer tiprId, String tiprNome) {
        this.tiprId = tiprId;
        this.tiprNome = tiprNome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiprId != null ? tiprId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProjeto)) {
            return false;
        }
        TipoProjeto other = (TipoProjeto) object;
        if ((this.tiprId == null && other.tiprId != null) || (this.tiprId != null && !this.tiprId.equals(other.tiprId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TipoProjeto[ tiprId=" + tiprId + " ]";
    }

}
