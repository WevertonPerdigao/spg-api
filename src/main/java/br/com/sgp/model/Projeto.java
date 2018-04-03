package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "projeto")
public class Projeto implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Getter
	@Setter
	@Basic(optional = false)
	@Column(name = "proj_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer projId;

	@Getter
	@Setter
	@Basic(optional = false)
	@Column(name = "proj_nome")
	private String projNome;

	@Getter
	@Setter
	@Basic(optional = false)
	@Column(name = "proj_descricao")
	private String projDescricao;

	@Getter
	@Setter
	@Column(name = "proj_data_inicial")
	@Temporal(TemporalType.DATE)
	private Date projDataInicial;

	@Getter
	@Setter
	@Column(name = "proj_data_final")
	@Temporal(TemporalType.DATE)
	private Date projDataFinal;

	@Getter
	@Setter
	@Basic(optional = false)
	@Column(name = "proj_valor")
	private BigDecimal projValor;

	@Setter
	@Getter
	@JoinColumn(name = "proj_empr_id", referencedColumnName = "empr_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Empresa projEmprId;

	@JoinColumn(name = "proj_func_id", referencedColumnName = "func_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Funcionario projFuncId;

	@Setter
	@Getter
	@JoinColumn(name = "proj_sipr_id", referencedColumnName = "sipr_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private SituacaoProjeto projSiprId;

	@Getter
	@JoinColumn(name = "proj_tead_id", referencedColumnName = "tead_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private TermoAditivo projTeadId;

	@Transient
	private BigDecimal custo;

	
	public Projeto() {
	}

	public Projeto(Integer projId) {
		this.projId = projId;
	}

	public Projeto(Integer projId, String projNome, String projDescricao, BigDecimal projValor) {
		this.projId = projId;
		this.projNome = projNome;
		this.projDescricao = projDescricao;
		this.projValor = projValor;
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

}
