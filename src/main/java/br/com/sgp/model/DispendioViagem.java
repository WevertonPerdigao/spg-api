package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author weslley.magalhaes
 *
 */
@Getter
@Setter
@Entity
@Table(name = "projeto_dispendio_viagem")
public class DispendioViagem extends Dispendio implements Serializable {

    private static final long serialVersionUID = -4428232497739404426L;

    
	
    @Column(name = "prdv_tipo_viagem")
    private Character prdv_tipo_viagem;

    @Basic(optional = false)
    @Column(name = "prdv_data_saida")
    @Temporal(TemporalType.DATE)
    private Date prdv_data_saida;

    @Getter
    @Setter
    @Column(name = "prdv_data_retorno")
    @Temporal(TemporalType.DATE)
    private Date prdv_data_retorno;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "prdv_justificativa")
    private String prdv_justificativa;

    @Getter
    @Setter
    @Column(name = "prdv_valor_transporte")
    private BigDecimal prdv_valor_transporte;

    @Getter
    @Setter
    @Column(name = "prdv_valor_passagem_aerea")
    private BigDecimal prdv_valor_passagem_aerea;

    @Getter
    @Setter
    @Column(name = "prdv_valor_hospedagem")
    private BigDecimal prdv_valor_hospedagem;

    @Getter
    @Setter
    @Column(name = "prdv_valor_outros")
    private BigDecimal prdv_valor_outros;

    @Getter
    @Setter
    @JoinColumn(name = "prdv_cida_id_origem", referencedColumnName = "cida_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cidade prdv_cida_id_origem;

    @JoinColumn(name = "prdv_cida_id_destino", referencedColumnName = "cida_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cidade prdv_cida_id_destino;

    @Getter
    @Setter
    @JoinColumn(name = "prdv_func_id", referencedColumnName = "func_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Funcionario prdv_func_id;

	

    
    

}
