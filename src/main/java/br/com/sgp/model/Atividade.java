package br.com.sgp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="projeto_atividade")
public class Atividade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5265149857548385862L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="prat_id")
	private Integer id;	
	
	@Column(name="prat_nome")
	private String nome;
	@Column(name="prat_descricao")
	private String descricao;
		
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="prat_proj_id")
	private Projeto projeto;
	
	@ManyToOne
	@JoinColumn(name="prat_tiat_id")
	private TipoAtividade tipo;
	
	@Temporal(TemporalType.DATE)
	@JoinColumn(name="prat_data_inicial")
	private Date data_inicial;

	@Temporal(TemporalType.DATE)
	@JoinColumn(name="prat_data_final")
	private Date data_final;
	

	
	@ManyToOne
	@JoinColumn(name="prat_pai_id")
	private Atividade atividadePai;
	
	@Column(name="prat_ordem_atividade")
	private Integer ordem;
	
	@Column(name="prat_dependente")
	private boolean dependente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public TipoAtividade getTipo() {
		return tipo;
	}

	public void setTipo(TipoAtividade tipo) {
		this.tipo = tipo;
	}

	public Date getData_inicial() {
		return data_inicial;
	}

	public void setData_inicial(Date data_inicial) {
		this.data_inicial = data_inicial;
	}

	public Date getData_final() {
		return data_final;
	}

	public void setData_final(Date data_final) {
		this.data_final = data_final;
	}

	public Atividade getAtividadePai() {
		return atividadePai;
	}

	public void setAtividadePai(Atividade atividadePai) {
		this.atividadePai = atividadePai;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public boolean isDependente() {
		return dependente;
	}

	public void setDependente(boolean dependente) {
		this.dependente = dependente;
	}
	
	
}
