package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "projeto_dispendio_viagem")
public class ProjetoDispendioViagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prdv_id")
    private Integer prdvId;

    @Getter
    @Setter
    @Column(name = "prdv_tipo_viagem")
    private Character prdvTipoViagem;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "prdv_data_saida")
    @Temporal(TemporalType.DATE)
    private Date prdvDataSaida;

    @Getter
    @Setter
    @Column(name = "prdv_data_retorno")
    @Temporal(TemporalType.DATE)
    private Date prdvDataRetorno;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "prdv_justificativa")
    private String prdvJustificativa;

    @Getter
    @Setter
    @Column(name = "prdv_valor_transporte")
    private BigDecimal prdvValorTransporte;

    @Getter
    @Setter
    @Column(name = "prdv_valor_passagem_aerea")
    private BigDecimal prdvValorPassagemAerea;

    @Getter
    @Setter
    @Column(name = "prdv_valor_hospedagem")
    private BigDecimal prdvValorHospedagem;

    @Getter
    @Setter
    @Column(name = "prdv_valor_outros")
    private BigDecimal prdvValorOutros;

    @Getter
    @Setter
    @JoinColumn(name = "prdv_cida_id_origem", referencedColumnName = "cida_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cidade prdvCidaIdOrigem;

    @Getter
    @Setter
    @JoinColumn(name = "prdv_cida_id_destino", referencedColumnName = "cida_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cidade prdvCidaIdDestino;

    @Getter
    @Setter
    @JoinColumn(name = "prdv_func_id", referencedColumnName = "func_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Funcionario prdvFuncId;

    @Getter
    @Setter
    @JoinColumn(name = "prdv_prdi_id", referencedColumnName = "prdi_id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private ProjetoDispendio prdvPrdiId;

    public ProjetoDispendioViagem() {
    }

    public ProjetoDispendioViagem(Integer prdvId) {
        this.prdvId = prdvId;
    }

    public ProjetoDispendioViagem(Integer prdvId, Date prdvDataSaida, String prdvJustificativa) {
        this.prdvId = prdvId;
        this.prdvDataSaida = prdvDataSaida;
        this.prdvJustificativa = prdvJustificativa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prdvId != null ? prdvId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjetoDispendioViagem)) {
            return false;
        }
        ProjetoDispendioViagem other = (ProjetoDispendioViagem) object;
        if ((this.prdvId == null && other.prdvId != null) || (this.prdvId != null && !this.prdvId.equals(other.prdvId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProjetoDispendioViagem[ prdvId=" + prdvId + " ]";
    }

}
