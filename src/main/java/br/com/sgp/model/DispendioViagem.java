package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

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
@Table(name = "projeto_dispendio_viagem")
public class DispendioViagem extends Dispendio implements Serializable {

	private static final long serialVersionUID = -4428232497739404426L;

	@Column(name = "prdvTipoViagem")
	private Character prdv_tipo_viagem;

	@Basic(optional = false)
	@JsonProperty(value="prdvDataSaida",required=true)
	@Column(name = "prdv_data_saida")
	@Temporal(TemporalType.DATE)
	private Date data_saida;

	@Getter
	@Setter
	@JsonProperty("prdvDataRetorno")
	@Column(name = "prdv_data_retorno")
	@Temporal(TemporalType.DATE)
	private Date data_retorno;

	@Getter
	@Setter
	@Basic(optional = false)
	@JsonProperty("prdvJustificativa")
	@Column(name = "prdv_justificativa")
	private String justificativaViagem;

	@Getter
	@Setter
	@JsonProperty("prdvValorTransporte")
	@Column(name = "prdv_valor_transporte")
	private BigDecimal valorTransporte;

	@Getter
	@Setter
	@JsonProperty("prdvValorPassagemAerea")
	@Column(name = "prdv_valor_passagem_aerea")
	private BigDecimal valorPassagemAerea;

	@Getter
	@Setter
	@JsonProperty("prdvValorHospedagem")
	@Column(name = "prdv_valor_hospedagem")
	private BigDecimal valorHospedagem;

	@Getter
	@Setter
	@JsonProperty("prdvValorOutros")
	@Column(name = "prdv_valor_outros")
	private BigDecimal valorOutros;

	@Getter
	@Setter
	@JsonProperty("prdvCidaIdOrigem")
	@JoinColumn(name = "prdv_cida_id_origem", referencedColumnName = "cida_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Cidade cidadeOrigem;

	@JsonProperty("prdvCidaIdDestino")
	@JoinColumn(name = "prdv_cida_id_destino", referencedColumnName = "cida_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Cidade cidadeDestino;

	@Getter
	@Setter
	@JsonProperty("prdvFuncId")
	@JoinColumn(name = "prdv_func_id", referencedColumnName = "func_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
	private Funcionario funcionario;

	public Character getPrdv_tipo_viagem() {
		return prdv_tipo_viagem;
	}

	public void setPrdv_tipo_viagem(Character prdv_tipo_viagem) {
		this.prdv_tipo_viagem = prdv_tipo_viagem;
	}

	public Date getData_saida() {
		return data_saida;
	}

	public void setData_saida(Date data_saida) {
		this.data_saida = data_saida;
	}

	public Date getData_retorno() {
		return data_retorno;
	}

	public void setData_retorno(Date data_retorno) {
		this.data_retorno = data_retorno;
	}

	public String getJustificativaViagem() {
		return justificativaViagem;
	}

	public void setJustificativaViagem(String justificativaViagem) {
		this.justificativaViagem = justificativaViagem;
	}

	public BigDecimal getValorTransporte() {
		return valorTransporte;
	}

	public void setValorTransporte(BigDecimal valorTransporte) {
		this.valorTransporte = valorTransporte;
	}

	public BigDecimal getValorPassagemAerea() {
		return valorPassagemAerea;
	}

	public void setValorPassagemAerea(BigDecimal valorPassagemAerea) {
		this.valorPassagemAerea = valorPassagemAerea;
	}

	public BigDecimal getValorHospedagem() {
		return valorHospedagem;
	}

	public void setValorHospedagem(BigDecimal valorHospedagem) {
		this.valorHospedagem = valorHospedagem;
	}

	public BigDecimal getValorOutros() {
		return valorOutros;
	}

	public void setValorOutros(BigDecimal valorOutros) {
		this.valorOutros = valorOutros;
	}

	public Cidade getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(Cidade cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}

	public Cidade getCidadeDestino() {
		return cidadeDestino;
	}

	public void setCidadeDestino(Cidade cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	
}
