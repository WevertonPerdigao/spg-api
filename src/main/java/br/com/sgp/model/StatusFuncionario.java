package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "status_funcionario")
public class StatusFuncionario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stfu_id")
    private Integer stfuId;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "stfu_nome")
    private String stfuNome;

    public StatusFuncionario() {
    }

    public StatusFuncionario(Integer stfuId) {
        this.stfuId = stfuId;
    }

    public StatusFuncionario(Integer stfuId, String stfuNome) {
        this.stfuId = stfuId;
        this.stfuNome = stfuNome;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stfuId != null ? stfuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusFuncionario)) {
            return false;
        }
        StatusFuncionario other = (StatusFuncionario) object;
        if ((this.stfuId == null && other.stfuId != null) || (this.stfuId != null && !this.stfuId.equals(other.stfuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.StatusFuncionario[ stfuId=" + stfuId + " ]";
    }

	public Integer getStfuId() {
		return stfuId;
	}

	public void setStfuId(Integer stfuId) {
		this.stfuId = stfuId;
	}

	public String getStfuNome() {
		return stfuNome;
	}

	public void setStfuNome(String stfuNome) {
		this.stfuNome = stfuNome;
	}

    
}
