
package nomina;

/**
 *
 * @author crist
 */
public class nomina {
    private int hora, sueldo;
    private String nom;
    
    public nomina(int hora, String nombre){
        
      this.hora = hora;
      this.nom = nombre;
    }
    
    public void calcular_sueldo(){
        //el valor de la hora es de 40.000
        sueldo=40000*hora;
    }
    public void imprimir(){
        calcular_sueldo();
        System.out.println("El sueldo del empleado "+nom+" es $"+sueldo);
    }
}
