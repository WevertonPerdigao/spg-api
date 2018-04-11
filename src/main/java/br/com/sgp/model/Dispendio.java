package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;

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
	private Integer prdi_id;
	
	
	@Basic(optional = false)
	@Column(name = "prdi_titulo_fatura")
	private String prdi_titulo_fatura;

	@Column(name = "prdi_descricao")
	private String prdi_descricao;

	
	@JsonProperty(required=true)
	@Basic(optional = false)
	@Column(name = "prdi_justificativa")
	private String prdi_justificativa;

	@Column(name = "prdi_cnpj")
	private String prdi_cnpj;

	
	@Column(name = "prdi_data_nota_fiscal")
	@Temporal(TemporalType.DATE)
	private Date prdi_data_nota_fiscal;

	@Column(name = "prdi_nota_fiscal")
	private String prdi_nota_fiscal;

	
	@Column(name = "prdi_data_pagamento")
	@Temporal(TemporalType.DATE)
	private Date prdi_data_pagamento;

	@JsonProperty(required=true)
	@Basic(optional = false)
	@Column(name = "prdi_valor",columnDefinition=SqlType.MONEY)
	private BigDecimal prdi_valor;
	
	@ManyToOne
	private DispendioAnexo anexo;
	
	
	
	@JsonProperty(required=true,access=Access.WRITE_ONLY,value="prdi_proj_id")	
	@JoinColumn(name = "prdi_proj_id", referencedColumnName = "proj_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Projeto prdi_proj_id;

	@JsonProperty(required=true, value="prdi_tidi_id")
	@JoinColumn(name = "prdi_tidi_id", referencedColumnName = "tidi_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private TipoDispendio tipo;

	public Integer getPrdi_id() {
		return prdi_id;
	}

	public void setPrdi_id(Integer prdi_id) {
		this.prdi_id = prdi_id;
	}

	public String getPrdi_titulo_fatura() {
		return prdi_titulo_fatura;
	}

	public void setPrdi_titulo_fatura(String prdi_titulo_fatura) {
		this.prdi_titulo_fatura = prdi_titulo_fatura;
	}

	public String getPrdi_descricao() {
		return prdi_descricao;
	}

	public void setPrdi_descricao(String prdi_descricao) {
		this.prdi_descricao = prdi_descricao;
	}

	public String getPrdi_justificativa() {
		return prdi_justificativa;
	}

	public void setPrdi_justificativa(String prdi_justificativa) {
		this.prdi_justificativa = prdi_justificativa;
	}

	public String getPrdi_cnpj() {
		return prdi_cnpj;
	}

	public void setPrdi_cnpj(String prdi_cnpj) {
		this.prdi_cnpj = prdi_cnpj;
	}

	public Date getPrdi_data_nota_fiscal() {
		return prdi_data_nota_fiscal;
	}

	public void setPrdi_data_nota_fiscal(Date prdi_data_nota_fiscal) {
		this.prdi_data_nota_fiscal = prdi_data_nota_fiscal;
	}

	public String getPrdi_nota_fiscal() {
		return prdi_nota_fiscal;
	}

	public void setPrdi_nota_fiscal(String prdi_nota_fiscal) {
		this.prdi_nota_fiscal = prdi_nota_fiscal;
	}

	public Date getPrdi_data_pagamento() {
		return prdi_data_pagamento;
	}

	public void setPrdi_data_pagamento(Date prdi_data_pagamento) {
		this.prdi_data_pagamento = prdi_data_pagamento;
	}

	public BigDecimal getPrdi_valor() {
		return prdi_valor;
	}

	public void setPrdi_valor(BigDecimal prdi_valor) {
		this.prdi_valor = prdi_valor;
	}

	public DispendioAnexo getAnexo() {
		return anexo;
	}

	public void setAnexo(DispendioAnexo anexo) {
		this.anexo = anexo;
	}

	public Projeto getPrdi_proj_id() {
		return prdi_proj_id;
	}

	public void setPrdi_proj_id(Projeto prdi_proj_id) {
		this.prdi_proj_id = prdi_proj_id;
	}

	public TipoDispendio getTipo() {
		return tipo;
	}

	public void setTipo(TipoDispendio tipo) {
		this.tipo = tipo;
	}


	

}
