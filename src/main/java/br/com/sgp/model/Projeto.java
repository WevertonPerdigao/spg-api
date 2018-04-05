package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "projeto")
public class Projeto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4580818154009474002L;

	@Id
	@Basic(optional = false)
	@Column(name = "proj_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projId;

	@Basic(optional = false)
	@Column(name = "proj_nome")
	private String projNome;
	@Basic(optional = false)
	@Column(name = "proj_descricao")
	private String projDescricao;

	@Column(name = "proj_data_inicial")
	@Temporal(TemporalType.DATE)
	private Date projDataInicial;

	@Column(name = "proj_data_final")
	@Temporal(TemporalType.DATE)
	private Date projDataFinal;

	@Basic(optional = false)
	@Column(name = "proj_valor")
	private BigDecimal projValor;

	@JoinColumn(name = "proj_empr_id", referencedColumnName = "empr_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Empresa projEmprId;

	@JoinColumn(name = "proj_func_id", referencedColumnName = "func_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Funcionario projFuncId;

	@JoinColumn(name = "proj_sipr_id", referencedColumnName = "sipr_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private SituacaoProjeto projSiprId;

	@JoinColumn(name = "proj_tead_id", referencedColumnName = "tead_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private TermoAditivo projTeadId;

	@ManyToMany(cascade= {CascadeType.DETACH},fetch=FetchType.LAZY)
	@JoinTable(name = "projeto_tipo",// 
		joinColumns = { //
				@JoinColumn(name = "prti_proj_id",referencedColumnName = "proj_id")},// 
		inverseJoinColumns = {//
				@JoinColumn(name = "prti_tipr_id",referencedColumnName="tipr_id")})//
	private List<TipoProjeto> projTipos;

	@Transient
	private BigDecimal custo;

	public Projeto() {
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (projId != null ? projId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Projeto)) {
			return false;
		}
		Projeto other = (Projeto) object;
		if ((this.projId == null && other.projId != null)
				|| (this.projId != null && !this.projId.equals(other.projId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "model.Projeto[ projId=" + projId + " ]";
	}

	public Integer getProjId() {
		return projId;
	}

	public void setProjId(Integer projId) {
		this.projId = projId;
	}

	public String getProjNome() {
		return projNome;
	}

	public void setProjNome(String projNome) {
		this.projNome = projNome;
	}

	public String getProjDescricao() {
		return projDescricao;
	}

	public void setProjDescricao(String projDescricao) {
		this.projDescricao = projDescricao;
	}

	public Date getProjDataInicial() {
		return projDataInicial;
	}

	public void setProjDataInicial(Date projDataInicial) {
		this.projDataInicial = projDataInicial;
	}

	public Date getProjDataFinal() {
		return projDataFinal;
	}

	public void setProjDataFinal(Date projDataFinal) {
		this.projDataFinal = projDataFinal;
	}

	public BigDecimal getProjValor() {
		return projValor;
	}

	public void setProjValor(BigDecimal projValor) {
		this.projValor = projValor;
	}

	public Empresa getProjEmprId() {
		return projEmprId;
	}

	public void setProjEmprId(Empresa projEmprId) {
		this.projEmprId = projEmprId;
	}

	public Funcionario getProjFuncId() {
		return projFuncId;
	}

	public void setProjFuncId(Funcionario projFuncId) {
		this.projFuncId = projFuncId;
	}

	public SituacaoProjeto getProjSiprId() {
		return projSiprId;
	}

	public void setProjSiprId(SituacaoProjeto projSiprId) {
		this.projSiprId = projSiprId;
	}

	public TermoAditivo getProjTeadId() {
		return projTeadId;
	}

	public void setProjTeadId(TermoAditivo projTeadId) {
		this.projTeadId = projTeadId;
	}

	public BigDecimal getCusto() {
		return custo;
	}

	public void setCusto(BigDecimal custo) {
		this.custo = custo;
	}

	public List<TipoProjeto> getProjTipos() {
		return projTipos;
	}

	public void setProjTipos(List<TipoProjeto> projTipos) {
		this.projTipos = projTipos;
	}


	
	
}
