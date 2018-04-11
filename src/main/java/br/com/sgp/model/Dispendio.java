package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import br.com.sgp.util.SqlType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author weslley.magalhaes
 *
 */
@Getter
@Setter
@Entity
@Table(name = "projeto_dispendio")
@Inheritance(strategy = InheritanceType.JOINED)
public class Dispendio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="prdi_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Basic(optional = false)
	@Column(name = "prdi_titulo_fatura")
	private String tituloFatura;

	@Column(name = "prdi_descricao")
	private String descricao;

	
	@JsonProperty(required=true)
	@Basic(optional = false)
	@Column(name = "prdi_justificativa")
	private String justificativa;

	@Column(name = "prdi_cnpj")
	private String cnpj;

	
	@Column(name = "prdi_data_nota_fiscal")
	@Temporal(TemporalType.DATE)
	private Date dataNotaFiscal;

	@Column(name = "prdi_nota_fiscal")
	private String notaFiscal;

	
	@Column(name = "prdi_data_pagamento")
	@Temporal(TemporalType.DATE)
	private Date dataPagamento;

	@JsonProperty(required=true)
	@Basic(optional = false)
	@Column(name = "prdi_valor",columnDefinition=SqlType.MONEY)
	private BigDecimal valor;
	
	@ManyToOne
	private DispendioAnexo anexo;
	
	@JsonProperty(required=true,access=Access.WRITE_ONLY)	
	@JoinColumn(name = "prdi_proj_id", referencedColumnName = "proj_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Projeto projeto;

	@JsonProperty(required=true)
	@JoinColumn(name = "prdi_tidi_id", referencedColumnName = "tidi_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private TipoDispendio tipo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTituloFatura() {
		return tituloFatura;
	}

	public void setTituloFatura(String tituloFatura) {
		this.tituloFatura = tituloFatura;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataNotaFiscal() {
		return dataNotaFiscal;
	}

	public void setDataNotaFiscal(Date dataNotaFiscal) {
		this.dataNotaFiscal = dataNotaFiscal;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public DispendioAnexo getAnexo() {
		return anexo;
	}

	public void setAnexo(DispendioAnexo anexo) {
		this.anexo = anexo;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public TipoDispendio getTipo() {
		return tipo;
	}

	public void setTipo(TipoDispendio tipo) {
		this.tipo = tipo;
	}	
	
	

}
