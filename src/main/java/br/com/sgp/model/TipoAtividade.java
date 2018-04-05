package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "tipo_atividade")
public class TipoAtividade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tiat_id")
    private Integer tiatId;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "tiat_nome")
    private String tiatNome;

    public TipoAtividade() {
    }

    public TipoAtividade(Integer tiatId) {
        this.tiatId = tiatId;
    }

    public TipoAtividade(Integer tiatId, String tiatNome) {
        this.tiatId = tiatId;
        this.tiatNome = tiatNome;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiatId != null ? tiatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAtividade)) {
            return false;
        }
        TipoAtividade other = (TipoAtividade) object;
        if ((this.tiatId == null && other.tiatId != null) || (this.tiatId != null && !this.tiatId.equals(other.tiatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TipoAtividade[ tiatId=" + tiatId + " ]";
    }

	public Integer getTiatId() {
		return tiatId;
	}

	public void setTiatId(Integer tiatId) {
		this.tiatId = tiatId;
	}

	public String getTiatNome() {
		return tiatNome;
	}

	public void setTiatNome(String tiatNome) {
		this.tiatNome = tiatNome;
	}
    
    

}
