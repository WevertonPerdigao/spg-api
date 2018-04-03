package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "situacao_projeto")
public class SituacaoProjeto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sipr_id")
    private Integer siprId;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "sipr_nome")
    private String siprNome;

    @Getter
    @Setter
    @Column(name = "sipr_descricao")
    private String siprDescricao;

        public SituacaoProjeto() {
    }

    public SituacaoProjeto(Integer siprId) {
        this.siprId = siprId;
    }

    public SituacaoProjeto(Integer siprId, String siprNome) {
        this.siprId = siprId;
        this.siprNome = siprNome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (siprId != null ? siprId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SituacaoProjeto)) {
            return false;
        }
        SituacaoProjeto other = (SituacaoProjeto) object;
        if ((this.siprId == null && other.siprId != null) || (this.siprId != null && !this.siprId.equals(other.siprId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SituacaoProjeto[ siprId=" + siprId + " ]";
    }

}
