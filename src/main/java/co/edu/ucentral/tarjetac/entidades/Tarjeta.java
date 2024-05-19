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

    @Column(name = "TAR_NUMERO_DE_TARJETA", length = 16,nullable = false)
    private long numerotarjeta;

    @Temporal(TemporalType.DATE)
    @Column(name= "TAR_FECHA_DE_VENCIMIENTO", nullable = false)
    private Date fecha_vec;

    @Column(name = "TAR_DOCUMENTO", nullable = false)
    private int documento;

    @Column(name = "TAR_CUPO_DISPONIBLE", nullable = false)
    private long cupo;

    @Temporal(TemporalType.DATE)
    @Column(name = "TAR_FECHA_DE_CORTE", nullable = false)
    private Date fecha_cor;

    @Temporal(TemporalType.DATE)
    @Column(name = "TAR_FECHA_LIMITE_DE_PAGO", nullable = false)
    private Date fecha_lim;

    @Column(name = "TAR_SALDO_UTILIZADO", nullable = false)
    private long saldo;

    public void actualizarTarjeta(long numerotarjeta, Date fecha_vec, int documento, long cupo, Date fecha_cor, Date fecha_lim, long saldo){
     this.numerotarjeta = numerotarjeta;
     this.fecha_vec = fecha_vec;
     this.documento = documento;
     this.cupo = cupo;
     this.fecha_cor = fecha_cor;
     this.fecha_lim = fecha_lim;
     this.saldo = saldo;
    }
}
