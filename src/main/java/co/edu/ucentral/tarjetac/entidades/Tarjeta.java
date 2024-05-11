package co.edu.ucentral.tarjetac.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "TARJETAS")

public class Tarjeta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TARJETAS")
    @SequenceGenerator(name = "SEQ_TARJETAS", sequenceName = "SEQ_TARJETAS", allocationSize = 1)

    @Column(name = "TAR_CODIGO", nullable = false)
    private long serial;

    @Column(name = "TAR_NUMERO_DE_TARJETA", nullable = false)
    private int numerotarjeta;

    @Column(name= "TAR_FECHA_DE_VENCIMIENTO", nullable = false)
    private Date fecha_vec;

    @Column(name = "TAR_DOCUEMENTO_CLIENTE", nullable = false)
    private int documento;

    @Column(name = "TAR_CUPO_DISPONIBLE", nullable = false)
    private int cupo;

    @Column(name = "TAR_FECHA_DE_CORTE", nullable = false)
    private Date fecha_cor;

    @Column(name = "TAR_FECHA_LIMITE_DE_PAGO", nullable = false)
    private Date fecha_lim;

    @Column(name = "TAR_SALDO_UTILIZADO", nullable = false)
    private int saldo;
}
