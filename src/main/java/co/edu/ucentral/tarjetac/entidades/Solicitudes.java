package co.edu.ucentral.tarjetac.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Solicitud")
@Table(name = "SOLICITUDES")
public class Solicitudes implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SOLICITUDES")
    @SequenceGenerator(name = "SEQ_SOLCITUDES", sequenceName = "SEQ_SOLICITUDES", allocationSize = 1)
    @Column(name = "SOL_NUMERODESOLICITUD", nullable = false)
    private long serial;

    @Column(name= "SOL_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "SOL_APELLIDO", nullable = false)
    private String apellido;

    @Column(name = "SOL_CELULAR", nullable = false)
    private int celular;

    @Column(name = "SOL_CORREO", nullable = false)
    private String correo;

    @Column(name = "SOL_DOCUMENTO", nullable = false)
    private int documento;

    @Column(name = "SOL_SALARIO", nullable = false)
    private int salario;

    @Column(name = "SOL_GASTOS", nullable = false)
    private int gastos;

    @Column(name = "SOL_FECHA", nullable = false)
    private Date fecha;

    @Column(name = "SOL_COMENTARIO", nullable = false)
    private String comentario;

}
