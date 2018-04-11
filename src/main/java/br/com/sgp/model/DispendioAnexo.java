package br.com.sgp.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 *
 * @author weverton.perdigao
 */
@Entity
@Table(name = "projeto_dispendio_anexo")
public class DispendioAnexo implements Serializable {

    private static final long serialVersionUID = 1L;

    
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    
    @JsonProperty(value="comprovante")
    @Basic(optional = false)    
    private String comprovante;
    
    @Basic(optional = false)    
    @OneToOne(cascade = CascadeType.PERSIST)
    private Arquivo anexo;
    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComprovante() {
		return comprovante;
	}

	public void setComprovante(String comprovante) {
		this.comprovante = comprovante;
	}

	public Arquivo getAnexo() {
		return anexo;
	}

	public void setAnexo(Arquivo anexo) {
		this.anexo = anexo;
	}


    

}
