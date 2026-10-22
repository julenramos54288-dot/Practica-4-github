import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         boolean salir = false;
         while (! salir) {
             System.out.println("\n--- GESTION DE CITAS TALLER ---");
             System.out.println("1. Registrar nueva cita");
             System.out.println("2. Consultar citas por fecha");
             System.out.println("3. Calcular coste de servicio");
             System.out.println("4. Salir");
             System.out.print(" Seleccione una opcion: ");

            int opcion = scanner.nextInt ();
             if (opcion == 4) {
                 scanner.close();
                 salir = true;
                 System.out.println(" Saliendo del programa ...");
                 }
             }
    }
    public static void PedirDatosDelVehiculo(){
        String matricula;
        Scanner sc =new Scanner(System.in);
        matricula = sc.nextLine();
        matricula.toUpperCase();
        Pattern pt = Pattern.compile("([0-9]{4}[ ]?[BCDFGHJKLMNPRSTVWXYZ]{3})");
        Matcher mat = pt.matcher(matricula);
        while(!mat.matches()); {
            matricula = sc.nextLine();
            matricula.toUpperCase();
        }

    }
}