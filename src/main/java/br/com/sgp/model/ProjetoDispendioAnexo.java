package br.com.sgp.model;
import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author weverton.perdigao
 */
@Entity
@Table(name = "projeto_dispendio_anexo")
public class ProjetoDispendioAnexo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "prda_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prdaId;

    @Basic(optional = false)
    @Column(name = "prda_anexo")
    private String prdaAnexo;
    @Basic(optional = false)

    @Column(name = "prda_comprovante")
    private String prdaComprovante;

    @JoinColumn(name = "prda_prdi_id", referencedColumnName = "prdi_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ProjetoDispendio prdaPrdiId;

    public ProjetoDispendioAnexo() {
    }

    public ProjetoDispendioAnexo(Integer prdaId) {
        this.prdaId = prdaId;
    }

    public ProjetoDispendioAnexo(Integer prdaId, String prdaAnexo, String prdaComprovante) {
        this.prdaId = prdaId;
        this.prdaAnexo = prdaAnexo;
        this.prdaComprovante = prdaComprovante;
    }

    public Integer getPrdaId() {
        return prdaId;
    }

    public void setPrdaId(Integer prdaId) {
        this.prdaId = prdaId;
    }

    public String getPrdaAnexo() {
        return prdaAnexo;
    }

    public void setPrdaAnexo(String prdaAnexo) {
        this.prdaAnexo = prdaAnexo;
    }

    public String getPrdaComprovante() {
        return prdaComprovante;
    }

    public void setPrdaComprovante(String prdaComprovante) {
        this.prdaComprovante = prdaComprovante;
    }

    public ProjetoDispendio getPrdaPrdiId() {
        return prdaPrdiId;
    }

    public void setPrdaPrdiId(ProjetoDispendio prdaPrdiId) {
        this.prdaPrdiId = prdaPrdiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prdaId != null ? prdaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjetoDispendioAnexo)) {
            return false;
        }
        ProjetoDispendioAnexo other = (ProjetoDispendioAnexo) object;
        if ((this.prdaId == null && other.prdaId != null) || (this.prdaId != null && !this.prdaId.equals(other.prdaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProjetoDispendioAnexo[ prdaId=" + prdaId + " ]";
    }

}
