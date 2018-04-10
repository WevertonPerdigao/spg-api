package br.com.sgp.model;
import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author weverton.perdigao
 */
@Entity
@Table(name = "projeto_dispendio_anexo")
public class DispendioAnexo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic(optional = false)    
    private String comprovante;
    
    @Basic(optional = false)    
    @OneToOne(cascade = CascadeType.PERSIST)
    private Arquivo anexo;



}
