package co.edu.ucentral.tarjetac.dto;


import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class PagosDto implements Serializable {
    private long serial;

   //@NotNull(message = "El número de la tarjeta es obligatorio")
    private long numerotar;

    //@NotNull(message = "El monto a pagar es obligatorio")
    private long monto;
}
