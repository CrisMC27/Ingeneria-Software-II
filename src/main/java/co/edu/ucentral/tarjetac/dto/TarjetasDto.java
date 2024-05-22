package co.edu.ucentral.tarjetac.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class TarjetasDto implements Serializable {
    private long serial;
    private long numerotarjeta;
    @NotBlank(message = "La fecha de vencimiento es obligatoria")
    private Date fecha_vec;
    private int documento;
    private long cupo;
    @NotBlank(message = "La fecha de corte es obligatoria")
    private Date fecha_cor;
    @NotBlank(message = "La fecha limite de pago es obligatoria")
    private Date fecha_lim;
    private long saldo;

}
