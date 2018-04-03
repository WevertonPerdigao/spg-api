package br.com.sgp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "funcionario")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "func_id")

    private Integer funcId;

    @Basic(optional = false)
    @Column(name = "func_matricula")
    private Integer funcMatricula;

    @Basic(optional = false)
    @Column(name = "func_nome")
    private String funcNome;


    @Column(name = "func_cpf")
    private String funcCpf;


    @Column(name = "func_email")
    private String funcEmail;


    @JsonIgnore
    @Column(name = "func_senha")
    private String funcSenha;


    @Column(name = "func_descricao")
    private String funcDescricao;


    @Column(name = "func_data_admissao")
    @Temporal(TemporalType.DATE)
    private Date funcDataAdmissão;


    @Column(name = "func_aprovador")
    private Boolean funcAprovador;


    @Column(name = "func_salario")
    private BigDecimal funcSalario;

    @Column(name = "func_horas_mes")
    private Integer funcHorasMes;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "func_carg_id", referencedColumnName = "carg_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cargo funcCargId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "func_func_id", referencedColumnName = "func_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Funcao funcFuncId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "func_seto_id", referencedColumnName = "seto_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Setor funcSetoId;

    @JoinColumn(name = "func_perf_id", referencedColumnName = "perf_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Perfil funcPerfId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "func_stfu_id", referencedColumnName = "stfu_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private StatusFuncionario funcStfuId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "func_unid_id", referencedColumnName = "unid_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Unidade funcUnidId;

    public Funcionario() {
    }

    public Funcionario(Integer funcId) {
        this.funcId = funcId;
    }

    public Funcionario(Integer funcId, int funcMatricula, String funcNome) {
        this.funcId = funcId;
        this.funcMatricula = funcMatricula;
        this.funcNome = funcNome;
    }

}
