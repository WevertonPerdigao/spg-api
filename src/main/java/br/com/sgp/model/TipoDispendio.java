package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "tipo_dispendio")
public class TipoDispendio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tidi_id")
    private Integer tidiId;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "tidi_nome")
    private String tidiNome;

    @Getter
    @Setter
    @Column(name = "tidi_descricao")
    private String tidiDescricao;

    public TipoDispendio() {
    }

    public TipoDispendio(Integer tidiId) {
        this.tidiId = tidiId;
    }

    public TipoDispendio(Integer tidiId, String tidiNome) {
        this.tidiId = tidiId;
        this.tidiNome = tidiNome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tidiId != null ? tidiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDispendio)) {
            return false;
        }
        TipoDispendio other = (TipoDispendio) object;
        
        
        
        return equals(other);
        
    }
    
    
    public boolean equals(TipoDispendio t) {    	
    	if (t.getTidiId()==null || !t.getTidiId().equals(getTidiId())) {
			return false;
		}
        return true;
    }

    @Override
    public String toString() {
        return "model.TipoDispendio[ tidiId=" + tidiId + " ]";
    }

	public Integer getTidiId() {
		return tidiId;
	}

	public void setTidiId(Integer tidiId) {
		this.tidiId = tidiId;
	}

	public String getTidiNome() {
		return tidiNome;
	}

	public void setTidiNome(String tidiNome) {
		this.tidiNome = tidiNome;
	}

	public String getTidiDescricao() {
		return tidiDescricao;
	}

	public void setTidiDescricao(String tidiDescricao) {
		this.tidiDescricao = tidiDescricao;
	}

    
}
