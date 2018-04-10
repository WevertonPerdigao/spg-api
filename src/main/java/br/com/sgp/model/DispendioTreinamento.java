package br.com.sgp.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
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

	@Basic(optional = false)
	@Column(name = "prdt_ementa")
	private String prdtEmenta;

	@Basic(optional = false)
	@Column(name = "prdt_data_inicial")
	@Temporal(TemporalType.DATE)
	private Date dataInicio;

	@Column(name = "prdt_data_final")
	@Temporal(TemporalType.DATE)
	private Date dataFinal;

	@Column(name = "prdt_instrutor")
	private String instrutor;

	@OneToMany(mappedBy="treinamento")	
	private Set<Membro> participantes;

	public DispendioTreinamento() {
	}

	public String getPrdtEmenta() {
		return prdtEmenta;
	}

	public void setPrdtEmenta(String prdtEmenta) {
		this.prdtEmenta = prdtEmenta;
	}

	@Column(name = "prdt_id")
	@Override
	public Integer getId() {

		return super.getId();
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

	public Set<Membro> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Set<Membro> participantes) {
		this.participantes = participantes;
	}


	
}
