
package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author weverton.perdigao
 */
@Entity
@Table
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carg_id")
    private Integer cargId;

    @Getter
    @Setter
    @Column(name = "carg_nome")
    private String cargNome;

       public Cargo() {
    }

    public Cargo(Integer cargId) {
        this.cargId = cargId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cargId != null ? cargId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.cargId == null && other.cargId != null) || (this.cargId != null && !this.cargId.equals(other.cargId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cargo[ cargId=" + cargId + " ]";
    }

	public Integer getCargId() {
		return cargId;
	}

	public void setCargId(Integer cargId) {
		this.cargId = cargId;
	}

	public String getCargNome() {
		return cargNome;
	}

	public void setCargNome(String cargNome) {
		this.cargNome = cargNome;
	}
    
    

}
