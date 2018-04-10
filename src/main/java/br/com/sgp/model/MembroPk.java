package br.com.sgp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MembroPk implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5109946348219939854L;

	@Column(name="participantes_prdt_id")
	private Integer treinamento;
	
	@Column(name="participantes_func_id")
	private Integer funcionario;
	
}
