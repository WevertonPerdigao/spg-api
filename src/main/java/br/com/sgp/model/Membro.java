package br.com.sgp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "projeto_dispendio_treinamento_participante")
public class Membro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MembroPk membro;

	@JoinColumn(name = "participantes_prdt_id")
	private Funcionario funcionario;
	
	@JoinColumn(name = "participantes_func_id")
	private DispendioTreinamento treinamento;
	
	
	
	public MembroPk getMembro() {
		return membro;
	}

	public void setMembro(MembroPk membro) {
		this.membro = membro;
	}
	
	
	

}
