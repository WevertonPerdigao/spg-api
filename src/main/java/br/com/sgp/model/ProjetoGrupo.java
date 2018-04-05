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
@Table(name = "projeto_grupo")
public class ProjetoGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prgr_id")
    private Integer prgrId;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "prgr_nome")
    private String prgrNome;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "prgr_descricao")
    private String prgrDescricao;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "prgr_data_inicial")
    @Temporal(TemporalType.DATE)
    private Date prgrDataInicial;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "prgr_data_final")
    @Temporal(TemporalType.DATE)
    private Date prgrDataFinal;

    @Getter
    @Setter
    @Column(name = "prgr_dependente")
    private Boolean prgrDependente;

    @Getter
    @Setter
    @Column(name = "prgr_ordem_atividade")
    private Integer prgrOrdemAtividade;

    @Getter
    @Setter
    @JoinColumn(name = "prgr_proj_id", referencedColumnName = "proj_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Projeto prgrProjId;

    @Getter
    @Setter
    @JoinColumn(name = "prgr_pai_id", referencedColumnName = "prgr_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ProjetoGrupo prgrPaiId;

    @Getter
    @Setter
    @JoinColumn(name = "prgr_tiat_id", referencedColumnName = "tiat_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoAtividade prgrTiatId;

    public ProjetoGrupo() {
    }

    public ProjetoGrupo(Integer prgrId) {
        this.prgrId = prgrId;
    }

    public ProjetoGrupo(Integer prgrId, String prgrNome, String prgrDescricao, Date prgrDataInicial, Date prgrDataFinal) {
        this.prgrId = prgrId;
        this.prgrNome = prgrNome;
        this.prgrDescricao = prgrDescricao;
        this.prgrDataInicial = prgrDataInicial;
        this.prgrDataFinal = prgrDataFinal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prgrId != null ? prgrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjetoGrupo)) {
            return false;
        }
        ProjetoGrupo other = (ProjetoGrupo) object;
        if ((this.prgrId == null && other.prgrId != null) || (this.prgrId != null && !this.prgrId.equals(other.prgrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProjetoGrupo[ prgrId=" + prgrId + " ]";
    }

}
