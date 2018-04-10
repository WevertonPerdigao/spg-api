package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import br.com.sgp.util.SqlType;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "perfil")
public class Perfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perf_id")
    private Integer perfId;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "perf_nome")
    private String perfNome;

    @Getter
    @Setter
    @Column(name = "perf_descricao")
    private String perfDescricao;

    @Getter
    @Setter
    @Column(name = "perf_valor_inicial", columnDefinition = SqlType.MONEY)
    private BigDecimal perfValorInicial;

    @Getter
    @Setter
    @Column(name = "perf_valor_final",columnDefinition=SqlType.MONEY)
    private BigDecimal perfValorFinal;

    @Getter
    @Setter
    @Column(name = "perf_acesso_completo")
    private Boolean perfAcessoCompleto;

    public Perfil() {
    }

    public Perfil(Integer perfId) {
        this.perfId = perfId;
    }

    public Perfil(Integer perfId, String perfNome) {
        this.perfId = perfId;
        this.perfNome = perfNome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perfId != null ? perfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.perfId == null && other.perfId != null) || (this.perfId != null && !this.perfId.equals(other.perfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Perfil[ perfId=" + perfId + " ]";
    }

	public Integer getPerfId() {
		return perfId;
	}

	public void setPerfId(Integer perfId) {
		this.perfId = perfId;
	}

	public String getPerfNome() {
		return perfNome;
	}

	public void setPerfNome(String perfNome) {
		this.perfNome = perfNome;
	}

	public String getPerfDescricao() {
		return perfDescricao;
	}

	public void setPerfDescricao(String perfDescricao) {
		this.perfDescricao = perfDescricao;
	}

	public BigDecimal getPerfValorInicial() {
		return perfValorInicial;
	}

	public void setPerfValorInicial(BigDecimal perfValorInicial) {
		this.perfValorInicial = perfValorInicial;
	}

	public BigDecimal getPerfValorFinal() {
		return perfValorFinal;
	}

	public void setPerfValorFinal(BigDecimal perfValorFinal) {
		this.perfValorFinal = perfValorFinal;
	}

	public Boolean getPerfAcessoCompleto() {
		return perfAcessoCompleto;
	}

	public void setPerfAcessoCompleto(Boolean perfAcessoCompleto) {
		this.perfAcessoCompleto = perfAcessoCompleto;
	}
    
    

}
