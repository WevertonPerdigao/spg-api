package br.com.sgp.model;



import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.util.List;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "tipo_projeto")
public class TipoProjeto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @NotNull
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipr_id")
    private Integer tiprId;

    
    @NotNull
    @Basic(optional = false)
    @Column(name = "tipr_nome")
    private String tiprNome;

    @JsonBackReference
    @ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "projeto_tipo",// 
		joinColumns =  //
				@JoinColumn(name = "prti_tipr_id",referencedColumnName="tipr_id"),// 
		inverseJoinColumns = {//
				@JoinColumn(name = "prti_proj_id", referencedColumnName="proj_id"), })//
    private List<Projeto> projetos;
    


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

    public Integer getTiprId() {
		return tiprId;
	}

	public void setTiprId(Integer tiprId) {
		this.tiprId = tiprId;
	}

	public String getTiprNome() {
		return tiprNome;
	}

	public void setTiprNome(String tiprNome) {
		this.tiprNome = tiprNome;
	}

	@Override
    public String toString() {
        return "model.TipoProjeto[ tiprId=" + tiprId + " ]";
    }

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
    
    

	

}
