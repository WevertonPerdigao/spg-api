package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "termo_aditivo")
@JsonIgnoreProperties(ignoreUnknown=true)
public class TermoAditivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tead_id")
    private Integer teadId;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "tead_nome")
    private String teadNome;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "tead_num_referencia")
    private String teadNumReferencia;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "tead_data_inicial")
    @Temporal(TemporalType.DATE)
    private Date teadDataInicial;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "tead_data_final")
    @Temporal(TemporalType.DATE)
    private Date teadDataFinal;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "tead_valor")
    private BigDecimal teadValor;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "tead_data_recebimento")
    @Temporal(TemporalType.DATE)
    private Date teadDataRecebimento;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "tead_resp_emitente")
    private int teadRespEmitente;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "tead_resp_cliente")
    private int teadRespCliente;

    @ManyToOne(cascade= {CascadeType.REFRESH,CascadeType.PERSIST})
    private Arquivo arquivo;

    public TermoAditivo() {
    }

    public TermoAditivo(Integer teadId) {
        this.teadId = teadId;
    }

    public TermoAditivo(Integer teadId, String teadNome, String teadNumReferencia, Date teadDataInicial, Date teadDataFinal, BigDecimal teadValor, Date teadDataRecebimento, int teadRespEmitente, int teadRespCliente) {
        this.teadId = teadId;
        this.teadNome = teadNome;
        this.teadNumReferencia = teadNumReferencia;
        this.teadDataInicial = teadDataInicial;
        this.teadDataFinal = teadDataFinal;
        this.teadValor = teadValor;
        this.teadDataRecebimento = teadDataRecebimento;
        this.teadRespEmitente = teadRespEmitente;
        this.teadRespCliente = teadRespCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teadId != null ? teadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TermoAditivo)) {
            return false;
        }
        TermoAditivo other = (TermoAditivo) object;
        if ((this.teadId == null && other.teadId != null) || (this.teadId != null && !this.teadId.equals(other.teadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TermoAditivo[ teadId=" + teadId + " ]";
    }

	public Integer getTeadId() {
		return teadId;
	}

	public void setTeadId(Integer teadId) {
		this.teadId = teadId;
	}

	public String getTeadNome() {
		return teadNome;
	}

	public void setTeadNome(String teadNome) {
		this.teadNome = teadNome;
	}

	public String getTeadNumReferencia() {
		return teadNumReferencia;
	}

	public void setTeadNumReferencia(String teadNumReferencia) {
		this.teadNumReferencia = teadNumReferencia;
	}

	public Date getTeadDataInicial() {
		return teadDataInicial;
	}

	public void setTeadDataInicial(Date teadDataInicial) {
		this.teadDataInicial = teadDataInicial;
	}

	public Date getTeadDataFinal() {
		return teadDataFinal;
	}

	public void setTeadDataFinal(Date teadDataFinal) {
		this.teadDataFinal = teadDataFinal;
	}

	public BigDecimal getTeadValor() {
		return teadValor;
	}

	public void setTeadValor(BigDecimal teadValor) {
		this.teadValor = teadValor;
	}

	public Date getTeadDataRecebimento() {
		return teadDataRecebimento;
	}

	public void setTeadDataRecebimento(Date teadDataRecebimento) {
		this.teadDataRecebimento = teadDataRecebimento;
	}

	public int getTeadRespEmitente() {
		return teadRespEmitente;
	}

	public void setTeadRespEmitente(int teadRespEmitente) {
		this.teadRespEmitente = teadRespEmitente;
	}

	public int getTeadRespCliente() {
		return teadRespCliente;
	}

	public void setTeadRespCliente(int teadRespCliente) {
		this.teadRespCliente = teadRespCliente;
	}

	public Arquivo getArquivo() {
		return arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

    
}
