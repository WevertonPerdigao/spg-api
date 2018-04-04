package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "situacao_projeto")
public class SituacaoProjeto implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 5706953873463684801L;

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sipr_id")
    private Integer siprId;

    @Basic(optional = false)
    @Column(name = "sipr_nome")
    private String siprNome;

    @Column(name = "sipr_descricao")
    private String siprDescricao;
    

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

	public Integer getSiprId() {
		return siprId;
	}

	public void setSiprId(Integer siprId) {
		this.siprId = siprId;
	}

	public String getSiprNome() {
		return siprNome;
	}

	public void setSiprNome(String siprNome) {
		this.siprNome = siprNome;
	}

	public String getSiprDescricao() {
		return siprDescricao;
	}

	public void setSiprDescricao(String siprDescricao) {
		this.siprDescricao = siprDescricao;
	}

    
}
