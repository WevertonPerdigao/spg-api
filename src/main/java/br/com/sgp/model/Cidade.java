
package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id

    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cida_id")
    private Integer cidaId;

    @Getter
    @Setter
    @Column(name = "cida_nome")
    private String cidaNome;

    @Getter
    @Setter
    @Column(name = "cida_ibge")
    private Integer cidaIbge;

    @Getter
    @Setter
    @JoinColumn(name = "cida_esta_id", referencedColumnName = "esta_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Estado cidaEstaId;

    public Cidade() {
    }

    public Cidade(Integer cidaId) {
        this.cidaId = cidaId;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cidaId != null ? cidaId.hashCode() : 0);
        return hash;
    }

   
    @Override
    public String toString() {
        return "model.Cidade[ cidaId=" + cidaId + " ]";
    }

	public Integer getCidaId() {
		return cidaId;
	}

	public void setCidaId(Integer cidaId) {
		this.cidaId = cidaId;
	}

	public String getCidaNome() {
		return cidaNome;
	}

	public void setCidaNome(String cidaNome) {
		this.cidaNome = cidaNome;
	}

	public Integer getCidaIbge() {
		return cidaIbge;
	}

	public void setCidaIbge(Integer cidaIbge) {
		this.cidaIbge = cidaIbge;
	}

	public Estado getCidaEstaId() {
		return cidaEstaId;
	}

	public void setCidaEstaId(Estado cidaEstaId) {
		this.cidaEstaId = cidaEstaId;
	}

    
}
