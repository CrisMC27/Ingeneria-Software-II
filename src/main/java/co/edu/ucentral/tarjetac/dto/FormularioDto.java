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
public class FormularioDto implements Serializable {
    private long serial;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;
    @NotBlank(message = "El numero celular obligatorio")
    private int celular;
    @NotBlank(message = "El correo obligatorio")
    private String correo;
    @NotBlank(message = "El documento es obligatorio")
    private int documento;
    @NotBlank(message = "El salario obligatorio")
    private int salario;
    @NotBlank(message = "El gasto mensual obligatorio")
    private int gastos;
/*

*/
}