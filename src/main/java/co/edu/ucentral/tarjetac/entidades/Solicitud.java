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
@Builder
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

    @Column(name = "SOL_CELULAR", length = 10, nullable = false)
    private long celular;

    @Column(name = "SOL_CORREO", nullable = false)
    private String correo;

    @Column(name = "SOL_DOCUMENTO", length = 10, nullable = false)
    private long cedula;

    @Column(name = "SOL_SALARIO", nullable = false)
    private long salario;

    @Column(name = "SOL_GASTOS", nullable = false)
    private long gastos;

    @Column(name = "SOL_COMENTARIO", nullable = false)
    private String comentario;


    public void actualizarSolicitud(String nombre, String apellido, long celular, String correo,long cedula, long salario, long gastos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.correo = correo;
        this.cedula = cedula;
        this.salario = salario;
        this.gastos = gastos;
    }
}
