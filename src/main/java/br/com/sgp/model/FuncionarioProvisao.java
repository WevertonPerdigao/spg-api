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
@Table(name = "funcionario_provisao")
public class FuncionarioProvisao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fupr_id")
    private Integer fuprId;

    @Getter
    @Setter
    @Column(name = "fupr_referencia")
    private Integer fuprReferencia;

    @Getter
    @Setter
    @Column(name = "fupr_tipo_funcionario")
    private Character fuprTipoFuncionario;

    @Getter
    @Setter
    @Column(name = "fupr_matricula")
    private Integer fuprMatricula;

    @Getter
    @Setter
    @Column(name = "fupr_total_geral")
    private BigDecimal fuprTotalGeral;

    @Getter
    @Setter
    @Column(name = "fupr_hora_total")
    private Integer fuprHoraTotal;

    @Getter
    @Setter
    @Column(name = "fupr_hora_homem")
    private Double fuprHoraHomem;

    @Getter
    @Setter
    @JoinColumn(name = "fupr_func_id", referencedColumnName = "func_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Funcionario fuprFuncId;

    public FuncionarioProvisao() {
    }

    public FuncionarioProvisao(Integer fuprId) {
        this.fuprId = fuprId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fuprId != null ? fuprId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionarioProvisao)) {
            return false;
        }
        FuncionarioProvisao other = (FuncionarioProvisao) object;
        if ((this.fuprId == null && other.fuprId != null) || (this.fuprId != null && !this.fuprId.equals(other.fuprId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FuncionarioProvisao[ fuprId=" + fuprId + " ]";
    }

}
