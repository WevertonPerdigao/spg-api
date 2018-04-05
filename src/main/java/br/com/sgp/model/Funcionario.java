package br.com.sgp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "funcionario",
uniqueConstraints = {@UniqueConstraint(columnNames = { "func_email" })})
@EqualsAndHashCode
@ToString
@JsonIgnoreProperties(ignoreUnknown=true)
public class Funcionario implements Serializable {

    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -6955925785649210441L;

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


    
    @Email    
    @Column(name = "func_email",unique=true)
    private String funcEmail;


    @JsonProperty(access = com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY)
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

	public Integer getFuncId() {
		return funcId;
	}

	public void setFuncId(Integer funcId) {
		this.funcId = funcId;
	}

	public Integer getFuncMatricula() {
		return funcMatricula;
	}

	public void setFuncMatricula(Integer funcMatricula) {
		this.funcMatricula = funcMatricula;
	}

	public String getFuncNome() {
		return funcNome;
	}

	public void setFuncNome(String funcNome) {
		this.funcNome = funcNome;
	}

	public String getFuncCpf() {
		return funcCpf;
	}

	public void setFuncCpf(String funcCpf) {
		this.funcCpf = funcCpf;
	}

	public String getFuncEmail() {
		return funcEmail;
	}

	public void setFuncEmail(String funcEmail) {
		this.funcEmail = funcEmail;
	}

	public String getFuncSenha() {
		return funcSenha;
	}

	public void setFuncSenha(String funcSenha) {
		this.funcSenha = funcSenha;
	}

	public String getFuncDescricao() {
		return funcDescricao;
	}

	public void setFuncDescricao(String funcDescricao) {
		this.funcDescricao = funcDescricao;
	}

	public Date getFuncDataAdmissão() {
		return funcDataAdmissão;
	}

	public void setFuncDataAdmissão(Date funcDataAdmissão) {
		this.funcDataAdmissão = funcDataAdmissão;
	}

	public Boolean getFuncAprovador() {
		return funcAprovador;
	}

	public void setFuncAprovador(Boolean funcAprovador) {
		this.funcAprovador = funcAprovador;
	}

	public BigDecimal getFuncSalario() {
		return funcSalario;
	}

	public void setFuncSalario(BigDecimal funcSalario) {
		this.funcSalario = funcSalario;
	}

	public Integer getFuncHorasMes() {
		return funcHorasMes;
	}

	public void setFuncHorasMes(Integer funcHorasMes) {
		this.funcHorasMes = funcHorasMes;
	}

	public Cargo getFuncCargId() {
		return funcCargId;
	}

	public void setFuncCargId(Cargo funcCargId) {
		this.funcCargId = funcCargId;
	}

	public Funcao getFuncFuncId() {
		return funcFuncId;
	}

	public void setFuncFuncId(Funcao funcFuncId) {
		this.funcFuncId = funcFuncId;
	}

	public Setor getFuncSetoId() {
		return funcSetoId;
	}

	public void setFuncSetoId(Setor funcSetoId) {
		this.funcSetoId = funcSetoId;
	}

	public Perfil getFuncPerfId() {
		return funcPerfId;
	}

	public void setFuncPerfId(Perfil funcPerfId) {
		this.funcPerfId = funcPerfId;
	}

	public StatusFuncionario getFuncStfuId() {
		return funcStfuId;
	}

	public void setFuncStfuId(StatusFuncionario funcStfuId) {
		this.funcStfuId = funcStfuId;
	}

	public Unidade getFuncUnidId() {
		return funcUnidId;
	}

	public void setFuncUnidId(Unidade funcUnidId) {
		this.funcUnidId = funcUnidId;
	}
    

}
