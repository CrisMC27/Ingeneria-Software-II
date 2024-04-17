package co.edu.ucentral.tarjetac.dto;

//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
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
    private long serial;
   // @NotBlank(message = "La fecha es obligatorio")
    private Date fecha;
    //@NotBlank(message = "El comentario es obligatorio")
    private String comentario;

}
