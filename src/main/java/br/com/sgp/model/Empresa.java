package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empr_id")
    private Integer emprId;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "empr_razao_social")
    private String emprRazaoSocial;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "empr_nome_fantasia")
    private String emprNomeFantasia;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "empr_cnpj")
    private String emprCnpj;

    @Getter
    @Setter
    @Column(name = "empr_data_abertura")
    @Temporal(TemporalType.DATE)
    private Date emprDataAbertura;

    @Getter
    @Setter
    @Column(name = "empr_natureza_juridica")
    private String emprNaturezaJuridica;

    @Getter
    @Setter
    @Column(name = "empr_atividade")
    private String emprAtividade;

    @Getter
    @Setter
    @Column(name = "empr_endereco")
    private String emprEndereco;

    @Getter
    @Setter
    @Column(name = "empr_telefone")
    private String emprTelefone;

    @Getter
    @Setter
    @Column(name = "empr_email")
    private String emprEmail;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "empr_status")
    private boolean emprStatus;

    @Getter
    @Setter
    @JoinColumn(name = "empr_cida_id", referencedColumnName = "cida_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade emprCidaId;

    public Empresa() {
    }

    public Empresa(Integer emprId) {
        this.emprId = emprId;
    }

    public Empresa(Integer emprId, String emprRazaoSocial, String emprNomeFantasia, String emprCnpj, boolean emprStatus) {
        this.emprId = emprId;
        this.emprRazaoSocial = emprRazaoSocial;
        this.emprNomeFantasia = emprNomeFantasia;
        this.emprCnpj = emprCnpj;
        this.emprStatus = emprStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emprId != null ? emprId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.emprId == null && other.emprId != null) || (this.emprId != null && !this.emprId.equals(other.emprId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Empresa[ emprId=" + emprId + " ]";
    }

}
