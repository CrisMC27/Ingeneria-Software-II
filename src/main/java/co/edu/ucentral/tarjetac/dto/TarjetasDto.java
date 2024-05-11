package co.edu.ucentral.tarjetac.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class TarjetasDto implements Serializable {
    private long serial;
    @NotBlank(message = "El codigo de la tarjeta es obligatorio")
    private long numerotarjeta;
    @NotBlank(message = "La fecha de vencimiento es obligatoria")
    private Date fecha_vec;
    @NotBlank(message = "El documento es obligatorio")
    private int documento;
    @NotBlank(message = "El cupo es obligatorio")
    private int cupo;
    @NotBlank(message = "La fecha de corte es obligatoria")
    private Date fecha_cor;
    @NotBlank(message = "La fecha limite de pago es obligatoria")
    private Date fecha_lim;
    @NotBlank(message = "El saldo es obligatorio")
    private int saldo;

}
