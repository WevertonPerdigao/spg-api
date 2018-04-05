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
@Table(name = "projeto_dispendio")
public class ProjetoDispendio implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @Basic(optional = false)
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prdi_id")
    private Integer prdiId;


    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "prdi_titulo_fatura")
    private String prdiTituloFatura;

    @Getter
    @Setter
    @Column(name = "prdi_descricao")
    private String prdiDescricao;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "prdi_justificativa")
    private String prdiJustificativa;

    @Getter
    @Setter
    @Column(name = "prdi_cnpj")
    private String prdiCnpj;

    @Getter
    @Setter
    @Column(name = "prdi_data_nota_fiscal")
    @Temporal(TemporalType.DATE)
    private Date prdiDataNotaFiscal;

    @Getter
    @Setter
    @Column(name = "prdi_nota_fiscal")
    private String prdiNotaFiscal;

    @Getter
    @Setter
    @Column(name = "prdi_data_pagamento")
    @Temporal(TemporalType.DATE)
    private Date prdiDataPagamento;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "prdi_valor")
    private BigDecimal prdiValor;

    @Getter
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "prdvPrdiId", fetch = FetchType.LAZY)
    private ProjetoDispendioViagem projetoDispendioViagem;

    @Getter
    @JoinColumn(name = "prdi_proj_id", referencedColumnName = "proj_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Projeto prdiProjId;

    @Getter
    @JoinColumn(name = "prdi_tidi_id", referencedColumnName = "tidi_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoDispendio prdiTidiId;

    @Getter
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "prdoPrdiId", fetch = FetchType.LAZY)
    private ProjetoDispendioOutros projetoDispendioOutros;

    @Getter
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "prdtPrdiId", fetch = FetchType.LAZY)
    private ProjetoDispendioTreinamento projetoDispendioTreinamento;


    public ProjetoDispendio() {
    }

    public ProjetoDispendio(Integer prdiId) {
        this.prdiId = prdiId;
    }

    public ProjetoDispendio(Integer prdiId, String prdiTituloFatura, String prdiJustificativa, BigDecimal prdiValor) {
        this.prdiId = prdiId;
        this.prdiTituloFatura = prdiTituloFatura;
        this.prdiJustificativa = prdiJustificativa;
        this.prdiValor = prdiValor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prdiId != null ? prdiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjetoDispendio)) {
            return false;
        }
        ProjetoDispendio other = (ProjetoDispendio) object;
        if ((this.prdiId == null && other.prdiId != null) || (this.prdiId != null && !this.prdiId.equals(other.prdiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProjetoDispendio[ prdiId=" + prdiId + " ]";
    }

}
