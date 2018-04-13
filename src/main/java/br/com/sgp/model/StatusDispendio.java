package br.com.sgp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "projeto_dispendio_status")
public class StatusDispendio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8371789174197923617L;

	@JsonProperty("prdsPrdiId")
	@Id
	@OneToOne
	@JoinColumn(name = "prds_prdi_id", table = "projeto_dispendio_status")
	private Dispendio dispendio;

	@JsonProperty("prdsPrdiStatus")
	@Column(name = "prds_status")
	@Enumerated(EnumType.ORDINAL)
	private StatusAprovacao status;

	@JsonProperty("prds_func_id")
	@ManyToOne
	@JoinColumn(name = "prds_func_id", table = "projeto_dispendio_status")
	private Funcionario funcionario;

	@JsonProperty("prdsJustificativa")
	private String prds_justificativa;

	@JsonProperty("prds_data")
	private Date prds_data;

	public Dispendio getDispendio() {
		return dispendio;
	}

	public void setDispendio(Dispendio dispendio) {
		this.dispendio = dispendio;
	}

	public StatusAprovacao getStatus() {
		return status;
	}

	public void setStatus(StatusAprovacao status) {
		this.status = status;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getPrds_justificativa() {
		return prds_justificativa;
	}

	public void setPrds_justificativa(String prds_justificativa) {
		this.prds_justificativa = prds_justificativa;
	}

	public Date getPrds_data() {
		return prds_data;
	}

	public void setPrds_data(Date prds_data) {
		this.prds_data = prds_data;
	}

	
}
