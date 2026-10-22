import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
    public static String PedirDatosDelVehiculo(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Introduce la matricula de tu coche");
        String matricula = sc.nextLine();
        matricula.toUpperCase();
        Pattern pt = Pattern.compile("([0-9]{4}[ ]?[BCDFGHJKLMNPRSTVWXYZ]{3})");
        Matcher mat = pt.matcher(matricula);
        while(!mat.matches()); {
            matricula = sc.nextLine();
            matricula.toUpperCase();
        }
        return matricula;
    }
    public static LocalDate PedirFechaCita() {
        Scanner sc =new Scanner(System.in);
        String fecha;
        LocalDate fechaCita = null;
        boolean error;
       do {
           error =false;
           try {
               System.out.println("Introduce la fecha en la que desees la cita    (año/mes/dia)");
               fecha = sc.nextLine();
               fechaCita = LocalDate.parse(fecha);
           }catch (DateTimeParseException e){
               System.out.println("Error en el formato de la matricula");
               error=true;
           }
       }while (error) ;
        return fechaCita;
    }
}