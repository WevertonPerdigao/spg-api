package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "tipo_dispendio")
public class TipoDispendio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tidi_id")
    private Integer tidiId;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "tidi_nome")
    private String tidiNome;

    @Getter
    @Setter
    @Column(name = "tidi_descricao")
    private String tidiDescricao;

    public TipoDispendio() {
    }

    public TipoDispendio(Integer tidiId) {
        this.tidiId = tidiId;
    }

    public TipoDispendio(Integer tidiId, String tidiNome) {
        this.tidiId = tidiId;
        this.tidiNome = tidiNome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tidiId != null ? tidiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDispendio)) {
            return false;
        }
        TipoDispendio other = (TipoDispendio) object;
        if ((this.tidiId == null && other.tidiId != null) || (this.tidiId != null && !this.tidiId.equals(other.tidiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TipoDispendio[ tidiId=" + tidiId + " ]";
    }

}
