package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    @Column(name = "perf_valor_inicial")
    private BigDecimal perfValorInicial;

    @Getter
    @Setter
    @Column(name = "perf_valor_final")
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

}
