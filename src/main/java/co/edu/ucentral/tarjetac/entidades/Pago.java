package co.edu.ucentral.tarjetac.entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "PAGOS")

public class Pago implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PAGOS")
    @SequenceGenerator(name = "SEQ_PAGOS", sequenceName = "SEQ_PAGOS", allocationSize = 1)

    @Column(name = "PAG_CODIGO", nullable = false)
    private long serial;

    @Column(name = "PAG_NUMERO_TARJETA", nullable = false)
    private long numerotar;

    @Column(name = "PAG_MONTO", nullable = false)
    private long monto;

}
