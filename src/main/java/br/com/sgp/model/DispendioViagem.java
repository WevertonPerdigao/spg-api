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

	@Column(name = "prdv_tipo_viagem")
	private Character prdv_tipo_viagem;

	@Basic(optional = false)
	@JsonProperty("prdv_data_saida")
	@Column(name = "prdv_data_saida")
	@Temporal(TemporalType.DATE)
	private Date data_saida;

	@Getter
	@Setter
	@JsonProperty("prdv_data_retorno")
	@Column(name = "prdv_data_retorno")
	@Temporal(TemporalType.DATE)
	private Date data_retorno;

	@Getter
	@Setter
	@Basic(optional = false)
	@JsonProperty("prdv_justificativa")
	@Column(name = "prdv_justificativa")
	private String justificativaViagem;

	@Getter
	@Setter
	@JsonProperty("prdv_valor_transporte")
	@Column(name = "prdv_valor_transporte")
	private BigDecimal valorTransporte;

	@Getter
	@Setter
	@JsonProperty("prdv_valor_passagem_aerea")
	@Column(name = "prdv_valor_passagem_aerea")
	private BigDecimal valorPassagemAerea;

	@Getter
	@Setter
	@JsonProperty("prdv_valor_hospedagem")
	@Column(name = "prdv_valor_hospedagem")
	private BigDecimal valorHospedagem;

	@Getter
	@Setter
	@JsonProperty("prdv_valor_outros")
	@Column(name = "prdv_valor_outros")
	private BigDecimal valorOutros;

	@Getter
	@Setter
	@JsonProperty("prdv_cida_id_origem")
	@JoinColumn(name = "prdv_cida_id_origem", referencedColumnName = "cida_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Cidade cidadeOrigem;

	@JsonProperty("prdv_cida_id_destino")
	@JoinColumn(name = "prdv_cida_id_destino", referencedColumnName = "cida_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Cidade cidadeDestino;

	@Getter
	@Setter
	@JsonProperty("prdv_func_id")
	@JoinColumn(name = "prdv_func_id", referencedColumnName = "func_id")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Funcionario funcionario;

}
