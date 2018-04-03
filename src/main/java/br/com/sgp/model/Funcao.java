package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "funcao")
public class Funcao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "func_id")
    private Integer funcId;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "func_nome")
    private String funcNome;

    public Funcao() {
    }

    public Funcao(Integer funcId) {
        this.funcId = funcId;
    }

    public Funcao(Integer funcId, String funcNome) {
        this.funcId = funcId;
        this.funcNome = funcNome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (funcId != null ? funcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcao)) {
            return false;
        }
        Funcao other = (Funcao) object;
        if ((this.funcId == null && other.funcId != null) || (this.funcId != null && !this.funcId.equals(other.funcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Funcao[ funcId=" + funcId + " ]";
    }

}
