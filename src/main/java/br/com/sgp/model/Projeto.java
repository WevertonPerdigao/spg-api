package br.com.sgp.model;

import javax.persistence.*;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import br.com.sgp.util.SqlType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
	@Column(name = "proj_valor", columnDefinition = SqlType.MONEY)
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

	@ManyToMany(cascade = { CascadeType.DETACH }, fetch = FetchType.LAZY)
	@JoinTable(name = "projeto_tipo", //
			joinColumns = { //
					@JoinColumn(name = "prti_proj_id", referencedColumnName = "proj_id") }, //
			inverseJoinColumns = { //
					@JoinColumn(name = "prti_tipr_id", referencedColumnName = "tipr_id") }) //
	private List<TipoProjeto> projTipos;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "projeto_equipe", //
			joinColumns = { @JoinColumn(name = "preq_proj_id") }, inverseJoinColumns = {
					@JoinColumn(name = "preq_func_id") })
	private List<Funcionario> equipe;

	@OneToMany(mappedBy = "projeto", fetch = FetchType.LAZY)
	private List<Atividade> atividades;

	@JsonProperty("projeto_dispendios")
	@OneToMany(mappedBy = "projeto", fetch = FetchType.LAZY)
	// @JoinTable(name="projeto_dispendio",joinColumns = {@JoinColumn()})
	private Set<Dispendio> dispendios;

	@Transient
	private BigDecimal custo;

	@Transient
	private String cronograma;

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
		return equals(other);
	}

	public boolean equals(Projeto object) {
		Projeto other = object;
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

	public List<Funcionario> getEquipe() {
		return equipe;
	}

	public void setEquipe(List<Funcionario> equipe) {
		this.equipe = equipe;
	}

	/**
	 * sincroniza a lista de membros da equipe do projeto
	 * 
	 * @param list
	 */
	public void addMembro(List<Funcionario> list) {
		if (equipe == null) {
			equipe = new ArrayList<>(list);
		} else {
			List<Funcionario> userRemovidos = new ArrayList<>();
			for (Funcionario funcionario : equipe) {
				if (!list.contains(funcionario)) {
					userRemovidos.add(funcionario);
				}
			}
			equipe.removeAll(userRemovidos);

			for (Funcionario funcionario : list) {
				if (!equipe.contains(funcionario)) {
					equipe.add(funcionario);
				}
			}
		}
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	/**
	 * Metodo para pegar todos tipos de dispendios dos dispendios do projeto
	 * 
	 * @return
	 */
	public List<TipoDispendio> tiposDispendios() {
		List<TipoDispendio> list = new ArrayList<>();
		if (getDispendios() != null) {
			for (Dispendio d : getDispendios()) {
				if (!list.contains(d.getTipo())) {
					list.add(d.getTipo());
				}
			}
		}

		return list;
	}

	public Set<Dispendio> getDispendios() {
		return dispendios;
	}

	public void setDispendios(Set<Dispendio> dispendios) {
		this.dispendios = dispendios;
	}

	
	public String getCronograma() {

		if (getProjDataFinal()==null || getProjDataInicial()==null) {
			return "sem data definida";
		}
		long inicio = getProjDataInicial().getTime(), fim = getProjDataFinal().getTime(),
				hoje = Calendar.getInstance().getTimeInMillis();

		BigDecimal time = new BigDecimal(inicio - fim), passed = new BigDecimal(inicio-hoje);

		
		Float current =  time.divide(passed,MathContext.DECIMAL32).floatValue() *100;
		
		DecimalFormat formatter = new DecimalFormat("#.##");
		return current > 100 ? "100" : formatter.format(current) + "";
	}

	public void setCronograma(String cronograma) {
		this.cronograma = cronograma;
	}

}
