package nomina;
import java.util.Scanner;
public class impuestocarro {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, ingresa el valor del carro:");
        double valorCarro = scanner.nextDouble();

        System.out.println("Por favor, ingresa el año de fabricación del carro:");
        int añoFabricacion = scanner.nextInt();

        double impuesto = calcularImpuestoCarro(valorCarro, añoFabricacion);
        System.out.println("El impuesto a pagar por el carro es: $" + impuesto);

        scanner.close();
    }

        public static double calcularImpuestoCarro(double valor, int año) {
        double impuesto = 0.0;
        int añoActual = 2024; // Año actual ficticio para este ejemplo

        // Calculamos el impuesto basado en el valor y la antigüedad del carro
        if (año == añoActual) {
            impuesto = valor * 0.05; // Por ejemplo, el 5% del valor del carro si es del año actual
        } else {
            impuesto = valor * 0.03; // Por ejemplo, el 3% del valor del carro si no es del año actual
        }

        return impuesto;
    }
    }
