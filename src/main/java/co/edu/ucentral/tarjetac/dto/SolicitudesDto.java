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
public class SolicitudesDto implements Serializable {
    private long numerosolicitud;
        @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
        @NotBlank(message = "El apellido es obligatorio")
    private String apellido;
        @NotBlank(message = "El celular es obligatorio")
    private int celular;
        @NotBlank(message = "El correo es obligatorio")
    private String correo;
        @NotBlank(message = "El documento es obligatorio")
    private int documento;
        @NotBlank(message = "El salario es obligatorio")
    private int salario;
    @NotBlank(message = "El gasto mensual es obligatorio")
    private int gastos;

}
