package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "setor")
public class Setor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seto_id")
    private Integer setoId;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "seto_nome")
    private String setoNome;

    public Setor() {
    }

    public Setor(Integer setoId) {
        this.setoId = setoId;
    }

    public Setor(Integer setoId, String setoNome) {
        this.setoId = setoId;
        this.setoNome = setoNome;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (setoId != null ? setoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Setor)) {
            return false;
        }
        Setor other = (Setor) object;
        if ((this.setoId == null && other.setoId != null) || (this.setoId != null && !this.setoId.equals(other.setoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Setor[ setoId=" + setoId + " ]";
    }

	public Integer getSetoId() {
		return setoId;
	}

	public void setSetoId(Integer setoId) {
		this.setoId = setoId;
	}

	public String getSetoNome() {
		return setoNome;
	}

	public void setSetoNome(String setoNome) {
		this.setoNome = setoNome;
	}

    
}
