package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;
import java.util.Date;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 2033879897711187832L;
	
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

	public Integer getEmprId() {
		return emprId;
	}

	public void setEmprId(Integer emprId) {
		this.emprId = emprId;
	}

	public String getEmprRazaoSocial() {
		return emprRazaoSocial;
	}

	public void setEmprRazaoSocial(String emprRazaoSocial) {
		this.emprRazaoSocial = emprRazaoSocial;
	}

	public String getEmprNomeFantasia() {
		return emprNomeFantasia;
	}

	public void setEmprNomeFantasia(String emprNomeFantasia) {
		this.emprNomeFantasia = emprNomeFantasia;
	}

	public String getEmprCnpj() {
		return emprCnpj;
	}

	public void setEmprCnpj(String emprCnpj) {
		this.emprCnpj = emprCnpj;
	}

	public Date getEmprDataAbertura() {
		return emprDataAbertura;
	}

	public void setEmprDataAbertura(Date emprDataAbertura) {
		this.emprDataAbertura = emprDataAbertura;
	}

	public String getEmprNaturezaJuridica() {
		return emprNaturezaJuridica;
	}

	public void setEmprNaturezaJuridica(String emprNaturezaJuridica) {
		this.emprNaturezaJuridica = emprNaturezaJuridica;
	}

	public String getEmprAtividade() {
		return emprAtividade;
	}

	public void setEmprAtividade(String emprAtividade) {
		this.emprAtividade = emprAtividade;
	}

	public String getEmprEndereco() {
		return emprEndereco;
	}

	public void setEmprEndereco(String emprEndereco) {
		this.emprEndereco = emprEndereco;
	}

	public String getEmprTelefone() {
		return emprTelefone;
	}

	public void setEmprTelefone(String emprTelefone) {
		this.emprTelefone = emprTelefone;
	}

	public String getEmprEmail() {
		return emprEmail;
	}

	public void setEmprEmail(String emprEmail) {
		this.emprEmail = emprEmail;
	}

	public boolean isEmprStatus() {
		return emprStatus;
	}

	public void setEmprStatus(boolean emprStatus) {
		this.emprStatus = emprStatus;
	}

	public Cidade getEmprCidaId() {
		return emprCidaId;
	}

	public void setEmprCidaId(Cidade emprCidaId) {
		this.emprCidaId = emprCidaId;
	}
    
    

}
