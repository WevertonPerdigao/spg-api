package br.com.sgp.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.sgp.util.SqlType;

@Entity
@Table(name="funcionario_provisao")
public class Provisao implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4395123396409819855L;

	@Id
	@Column(name = "fupr_id")
	@JsonProperty("fuprId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonBackReference
	@JsonProperty("fuprFuncId")
	@ManyToOne
	@JoinColumn(name = "fupr_func_id") 
	private Funcionario funcionario;
	
	@JsonProperty("fuprReferencia")
	@Column(name="fupr_referencia")
	private Integer referencia;

	
	@JsonProperty("fuprTipoFuncionario")
	@Column(name = "fupr_tipo_funcionario")
	private Character tipo;
	
	/**
	 * Total de horas de trabalho
	 */
	@JsonProperty("fuprHoraTotal")
	@Column(name = "fupr_hora_total")
	private Integer hora;
	
	/**
	 * Total da provisao
	 */
	@JsonProperty("fuprTotalGeral")
	@Column(name="fupr_total_geral",columnDefinition = SqlType.MONEY)
	private BigDecimal  total;
	
	
	/**
	 * Total de hora por homem
	 * 
	 */
	@JsonProperty("fuprHoraHomem")
	@Column(name = "fupr_hora_homem")
	private Float horaHomem;
	
	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public Integer getReferencia() {
		return referencia;
	}


	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}


	public Character getTipo() {
		return tipo;
	}


	public void setTipo(Character tipo) {
		this.tipo = tipo;
	}


	public Integer getHora() {
		return hora;
	}


	public void setHora(Integer hora) {
		this.hora = hora;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public Float getHoraHomem() {
		return horaHomem;
	}


	public void setHoraHomem(Float horaHomem) {
		this.horaHomem = horaHomem;
	}

	
}
