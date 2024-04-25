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
@Entity
@Table(name = "SOLICITUDES")
public class Solicitud implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SOLICITUDES")
    @SequenceGenerator(name = "SEQ_SOLICITUDES", sequenceName = "SEQ_SOLICITUDES", allocationSize = 1)

    @Column(name = "SOL_NUMERO_DE_SOLICITUD", nullable = false)
    private long numerosolicitud;

    @Column(name= "SOL_NOMBRES", nullable = false)
    private String nombre;

    @Column(name = "SOL_APELLIDOS", nullable = false)
    private String apellido;

    @Column(name = "SOL_CELULAR", nullable = false)
    private int celular;

    @Column(name = "SOL_CORREO", nullable = false)
    private String correo;

    @Column(name = "SOL_DOCUMENTO", nullable = false)
    private int cedula;

    @Column(name = "SOL_SALARIO", nullable = false)
    private int salario;

    @Column(name = "SOL_GASTOS", nullable = false)
    private int gastos;

    @Column(name = "SOL_FECHA", nullable = false)
    private Date fecha;

    @Column(name = "SOL_COMENTARIO", nullable = false)
    private String comentario;

}
