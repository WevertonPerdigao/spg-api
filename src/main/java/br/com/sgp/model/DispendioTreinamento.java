package br.com.sgp.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "projeto_dispendio_treinamento")
public class DispendioTreinamento extends Dispendio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6946366741648890204L;

	@JsonProperty(required = true,value="prdtEmenta")
	@Basic(optional = false)	
	@Column(name = "prdt_ementa")
	private String ementa;
	
	@JsonProperty(required = true,value="prdtDataInicial")
	@Basic(optional = false)
	@Column(name = "prdt_data_inicial")
	@Temporal(TemporalType.DATE)
	private Date dataInicio;

	
	@JsonProperty(required = false,value="prdtDataFinal")
	@Column(name = "prdt_data_final")
	@Temporal(TemporalType.DATE)
	private Date dataFinal;

	@JsonProperty(required = false,value="prdtInstrutor")
	@Column(name = "prdt_instrutor")
	private String instrutor;

	
	@JsonProperty(value="projetoDispendioTreinamentoParticipante")
	@OneToMany(cascade = CascadeType.DETACH)
	@JoinTable(name = "projeto_dispendio_treinamento_participante", joinColumns = {
			@JoinColumn(name = "participantes_prdt_id", referencedColumnName = "prdi_id") }, //
			inverseJoinColumns = { @JoinColumn(name = "participantes_func_id", referencedColumnName = "func_id") })
	private Set<Funcionario> participantes;

	
	public DispendioTreinamento() {
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(String instrutor) {
		this.instrutor = instrutor;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public Set<Funcionario> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Set<Funcionario> participantes) {
		this.participantes = participantes;
	}

}
