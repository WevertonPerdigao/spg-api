package br.com.sgp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
/**
 * @author weverton.perdigao
 */
@Entity
@Table(name = "projeto_dispendio_viagem")
public class DispendioViagem extends Dispendio implements Serializable {

    private static final long serialVersionUID = -4428232497739404426L;

	
    @Column(name = "prdv_tipo_viagem")
    private Character tipoViagem;

    @Basic(optional = false)
    @Column(name = "prdv_data_saida")
    @Temporal(TemporalType.DATE)
    private Date dataSaida;

    @Getter
    @Setter
    @Column(name = "prdv_data_retorno")
    @Temporal(TemporalType.DATE)
    private Date dataRetorno;

    @Getter
    @Setter
    @Basic(optional = false)
    @Column(name = "prdv_justificativa")
    private String justificativaViagem;

    @Getter
    @Setter
    @Column(name = "prdv_valor_transporte")
    private BigDecimal valorTransporte;

    @Getter
    @Setter
    @Column(name = "prdv_valor_passagem_aerea")
    private BigDecimal valorPassagem;

    @Getter
    @Setter
    @Column(name = "prdv_valor_hospedagem")
    private BigDecimal valorHospedagem;

    @Getter
    @Setter
    @Column(name = "prdv_valor_outros")
    private BigDecimal valorOutros;

    @Getter
    @Setter
    @JoinColumn(name = "prdv_cida_id_origem", referencedColumnName = "cida_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cidade cidadeOrigem;

    @JoinColumn(name = "prdv_cida_id_destino", referencedColumnName = "cida_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cidade cidadeDestino;

    @Getter
    @Setter
    @JoinColumn(name = "prdv_func_id", referencedColumnName = "func_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Funcionario funcionario;


    @Column(name="prdv_id")
    @Override
    public Integer getId() {
    	// TODO Auto-generated method stub
    	return super.getId();
    }

}
