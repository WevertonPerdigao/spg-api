package br.com.sgp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "projeto_dispendio_treinamento")
public class ProjetoDispendioTreinamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prdt_id")
    private Integer prdtId;
    @Basic(optional = false)
    @Column(name = "prdt_ementa")
    private String prdtEmenta;
    @Basic(optional = false)
    @Column(name = "prdt_data_inicial")
    @Temporal(TemporalType.DATE)
    private Date prdtDataInicial;
    @Column(name = "prdt_data_final")
    @Temporal(TemporalType.DATE)
    private Date prdtDataFinal;
    @Column(name = "prdt_instrutor")
    private String prdtInstrutor;

    @JoinColumn(name = "prdt_prdi_id", referencedColumnName = "prdi_id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private ProjetoDispendio prdtPrdiId;

    public ProjetoDispendioTreinamento() {
    }

    public ProjetoDispendioTreinamento(Integer prdtId) {
        this.prdtId = prdtId;
    }

    public ProjetoDispendioTreinamento(Integer prdtId, String prdtEmenta, Date prdtDataInicial) {
        this.prdtId = prdtId;
        this.prdtEmenta = prdtEmenta;
        this.prdtDataInicial = prdtDataInicial;
    }

    public Integer getPrdtId() {
        return prdtId;
    }

    public void setPrdtId(Integer prdtId) {
        this.prdtId = prdtId;
    }

    public String getPrdtEmenta() {
        return prdtEmenta;
    }

    public void setPrdtEmenta(String prdtEmenta) {
        this.prdtEmenta = prdtEmenta;
    }

    public Date getPrdtDataInicial() {
        return prdtDataInicial;
    }

    public void setPrdtDataInicial(Date prdtDataInicial) {
        this.prdtDataInicial = prdtDataInicial;
    }

    public Date getPrdtDataFinal() {
        return prdtDataFinal;
    }

    public void setPrdtDataFinal(Date prdtDataFinal) {
        this.prdtDataFinal = prdtDataFinal;
    }

    public String getPrdtInstrutor() {
        return prdtInstrutor;
    }

    public void setPrdtInstrutor(String prdtInstrutor) {
        this.prdtInstrutor = prdtInstrutor;
    }

    public ProjetoDispendio getPrdtPrdiId() {
        return prdtPrdiId;
    }

    public void setPrdtPrdiId(ProjetoDispendio prdtPrdiId) {
        this.prdtPrdiId = prdtPrdiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prdtId != null ? prdtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjetoDispendioTreinamento)) {
            return false;
        }
        ProjetoDispendioTreinamento other = (ProjetoDispendioTreinamento) object;
        if ((this.prdtId == null && other.prdtId != null) || (this.prdtId != null && !this.prdtId.equals(other.prdtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProjetoDispendioTreinamento[ prdtId=" + prdtId + " ]";
    }

}
