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

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4643411758248460453L;

	@Id
	@Column(name="prdiId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("prdiId")
	private Integer id;
	
	@JsonProperty("prdiTituloFatura")
	@Basic(optional = false)
	@Column(name = "prdi_titulo_fatura")
	private String titulo_fatura;

	@JsonProperty(required=true,value="prdiDescricao")	
	@Column(name = "prdi_descricao")
	private String descricao;

	
	@JsonProperty(required=true,value="prdiJustificativa")
	@Basic(optional = false)
	@Column(name = "prdi_justificativa")
	private String justificativa;

	@JsonProperty(required=true,value="prdiCnpj")
	@Column(name = "prdi_cnpj")
	private String cnpj;

	@JsonProperty(required=true,value="prdiDataNotaFiscal")
	@Column(name = "prdi_data_nota_fiscal")
	@Temporal(TemporalType.DATE)
	private Date data_nota_fiscal;

	@JsonProperty(required=true,value="prdiNotaFiscal")
	@Column(name = "prdi_nota_fiscal")
	private String prdi_nota_fiscal;

	@JsonProperty(required=true,value="prdiDataPagamento")
	@Column(name = "prdi_data_pagamento")
	@Temporal(TemporalType.DATE)
	private Date data_pagamento;

	@JsonProperty(required=true,value="prdiValor")
	@Basic(optional = false)
	@Column(name = "prdi_valor",columnDefinition=SqlType.MONEY)
	private BigDecimal valor;
	
	@ManyToOne
	private DispendioAnexo anexo;
	
	@JsonProperty(required=true,access=Access.WRITE_ONLY,value="prdiProjId")	
	@JoinColumn(name = "prdi_proj_id", referencedColumnName = "proj_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Projeto projeto;

	@JsonProperty(required=true, value="prdiTidiId")
	@JoinColumn(name = "prdi_tidi_id", referencedColumnName = "tidi_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private TipoDispendio tipo;

	@JsonProperty("prdiFuncId")
	@ManyToOne
	@JoinColumn(name="prdi_func_id",referencedColumnName = "func_id")
	private Funcionario funcionario;
	
	@JsonProperty("prdsPrdiId")
	@OneToOne(mappedBy="dispendio",cascade = {CascadeType.ALL})	
	private StatusDispendio status;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo_fatura() {
		return titulo_fatura;
	}

	public void setTitulo_fatura(String titulo_fatura) {
		this.titulo_fatura = titulo_fatura;
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

	public Date getData_nota_fiscal() {
		return data_nota_fiscal;
	}

	public void setData_nota_fiscal(Date data_nota_fiscal) {
		this.data_nota_fiscal = data_nota_fiscal;
	}

	public String getPrdi_nota_fiscal() {
		return prdi_nota_fiscal;
	}

	public void setPrdi_nota_fiscal(String prdi_nota_fiscal) {
		this.prdi_nota_fiscal = prdi_nota_fiscal;
	}

	public Date getData_pagamento() {
		return data_pagamento;
	}

	public void setData_pagamento(Date data_pagamento) {
		this.data_pagamento = data_pagamento;
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

	public StatusDispendio getStatus() {
		return status;
	}

	public void setStatus(StatusDispendio status) {
		this.status = status;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	
}
