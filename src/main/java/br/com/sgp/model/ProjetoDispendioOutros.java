package br.com.sgp.model;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author weverton.perdigao
 */
@Entity
@Table(name = "projeto_dispendio_outros")
public class ProjetoDispendioOutros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prdo_id")
    private Integer prdoId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prdo_valor_aluguel")
    private BigDecimal prdoValorAluguel;
    @Column(name = "prdo_valor_condominio")
    private BigDecimal prdoValorCondominio;
    @Column(name = "prdo_valor_energia")
    private BigDecimal prdoValorEnergia;
    @Column(name = "prdo_valor_estacionamento")
    private BigDecimal prdoValorEstacionamento;
    @Column(name = "prdo_valor_internet")
    private BigDecimal prdoValorInternet;
    @Column(name = "prdo_valor_taxi")
    private BigDecimal prdoValorTaxi;
    @Column(name = "prdo_valor_telefone")
    private BigDecimal prdoValorTelefone;
    @Column(name = "prdo_valor_manutencao_geral")
    private BigDecimal prdoValorManutencaoGeral;
    @Column(name = "prdo_valor_medico_ocupacional")
    private BigDecimal prdoValorMedicoOcupacional;
    @Column(name = "prdo_valor_servico_entrega")
    private BigDecimal prdoValorServicoEntrega;
    @Column(name = "prdo_valor_inss")
    private BigDecimal prdoValorInss;
    @JoinColumn(name = "prdo_prdi_id", referencedColumnName = "prdi_id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private ProjetoDispendio prdoPrdiId;

    public ProjetoDispendioOutros() {
    }

    public ProjetoDispendioOutros(Integer prdoId) {
        this.prdoId = prdoId;
    }

    public Integer getPrdoId() {
        return prdoId;
    }

    public void setPrdoId(Integer prdoId) {
        this.prdoId = prdoId;
    }

    public BigDecimal getPrdoValorAluguel() {
        return prdoValorAluguel;
    }

    public void setPrdoValorAluguel(BigDecimal prdoValorAluguel) {
        this.prdoValorAluguel = prdoValorAluguel;
    }

    public BigDecimal getPrdoValorCondominio() {
        return prdoValorCondominio;
    }

    public void setPrdoValorCondominio(BigDecimal prdoValorCondominio) {
        this.prdoValorCondominio = prdoValorCondominio;
    }

    public BigDecimal getPrdoValorEnergia() {
        return prdoValorEnergia;
    }

    public void setPrdoValorEnergia(BigDecimal prdoValorEnergia) {
        this.prdoValorEnergia = prdoValorEnergia;
    }

    public BigDecimal getPrdoValorEstacionamento() {
        return prdoValorEstacionamento;
    }

    public void setPrdoValorEstacionamento(BigDecimal prdoValorEstacionamento) {
        this.prdoValorEstacionamento = prdoValorEstacionamento;
    }

    public BigDecimal getPrdoValorInternet() {
        return prdoValorInternet;
    }

    public void setPrdoValorInternet(BigDecimal prdoValorInternet) {
        this.prdoValorInternet = prdoValorInternet;
    }

    public BigDecimal getPrdoValorTaxi() {
        return prdoValorTaxi;
    }

    public void setPrdoValorTaxi(BigDecimal prdoValorTaxi) {
        this.prdoValorTaxi = prdoValorTaxi;
    }

    public BigDecimal getPrdoValorTelefone() {
        return prdoValorTelefone;
    }

    public void setPrdoValorTelefone(BigDecimal prdoValorTelefone) {
        this.prdoValorTelefone = prdoValorTelefone;
    }

    public BigDecimal getPrdoValorManutencaoGeral() {
        return prdoValorManutencaoGeral;
    }

    public void setPrdoValorManutencaoGeral(BigDecimal prdoValorManutencaoGeral) {
        this.prdoValorManutencaoGeral = prdoValorManutencaoGeral;
    }

    public BigDecimal getPrdoValorMedicoOcupacional() {
        return prdoValorMedicoOcupacional;
    }

    public void setPrdoValorMedicoOcupacional(BigDecimal prdoValorMedicoOcupacional) {
        this.prdoValorMedicoOcupacional = prdoValorMedicoOcupacional;
    }

    public BigDecimal getPrdoValorServicoEntrega() {
        return prdoValorServicoEntrega;
    }

    public void setPrdoValorServicoEntrega(BigDecimal prdoValorServicoEntrega) {
        this.prdoValorServicoEntrega = prdoValorServicoEntrega;
    }

    public BigDecimal getPrdoValorInss() {
        return prdoValorInss;
    }

    public void setPrdoValorInss(BigDecimal prdoValorInss) {
        this.prdoValorInss = prdoValorInss;
    }

    public ProjetoDispendio getPrdoPrdiId() {
        return prdoPrdiId;
    }

    public void setPrdoPrdiId(ProjetoDispendio prdoPrdiId) {
        this.prdoPrdiId = prdoPrdiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prdoId != null ? prdoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjetoDispendioOutros)) {
            return false;
        }
        ProjetoDispendioOutros other = (ProjetoDispendioOutros) object;
        if ((this.prdoId == null && other.prdoId != null) || (this.prdoId != null && !this.prdoId.equals(other.prdoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProjetoDispendioOutros[ prdoId=" + prdoId + " ]";
    }

}
