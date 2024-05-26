package co.edu.ucentral.tarjetac.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@Builder
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
    private int celular;
    @NotBlank(message = "El correo es obligatorio")
    private String correo;
    private int cedula;
    private int salario;
    private int gastos;
    @NotBlank(message = "El comentario es obligatorio")
    private String comentario;
}