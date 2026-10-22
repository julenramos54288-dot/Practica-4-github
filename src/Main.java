import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.format. DateTimeFormatter ;

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

    public class GestorFechas {
         // Constante con el patron de formato espa ´ nol ˜
         private static final String PATRON_FECHA = "dd/MM/yyyy HH:mm";

         // Formateador reutilizable configurado con la localizacion en español
         private static final DateTimeFormatter FORMATO_ESPANOL = DateTimeFormatter . ofPattern (PATRON_FECHA , new Locale("es", "ES"));

         /**
          * Convierte un objeto LocalDateTime a una cadena con formato espanol dd/MM/yyyy HH:mm *
          ** @param fechaHora Objeto LocalDateTime a formatear
          * @return Cadena de texto formateada o mensaje de error si el parametro es nulo ´
          */
         public static String formatearFechaEspanol ( LocalDateTime fechaHora ) {
             if ( fechaHora == null) {
                 return "Fecha no disponible ";
                 }
             return fechaHora .format( FORMATO_ESPANOL );
             }

         /**
         * Pide al usuario una fecha y hora por consola , valida la entrada
         * y la devuelve como objeto LocalDateTime .*
         * @param scanner Objeto Scanner activo
         * @return LocalDateTime introducido por el usuario o la fecha actual si falla
         */
         public static LocalDateTime leerYValidarFecha (Scanner scanner) {
             System.out.print(" Introduzca la fecha y hora de la cita (" + PATRON_FECHA + "): ");
             String entrada = scanner. nextLine ().trim ();

             try {
                 // Intenta parsear la cadena ingresada según el patron definido ´
                 LocalDateTime fechaParseada =
                        LocalDateTime .parse(entrada , FORMATO_ESPANOL );
                 System.out.println(" Fecha registrada correctamente.");
                         return fechaParseada ;

                 } catch ( DateTimeParseException e) {
                 System.out.println("Formato incorrecto. Debe usar exactamente el formato: dd/MM/yyyy HH:mm");
                 System.out.println("Se asignar´a la fecha y hora actual por defecto.");
                 return LocalDateTime .now ();
                 }
             }

         /**
        * Ejemplo de prueba para invocar desde la opcion correspondiente del menú.
         */
         public static void probarFormatoFecha (Scanner scanner) {
             System.out.println("\n--- CONSULTA Y REGISTRO DE FECHAS ---");

                // 1. Mostrar la fecha/hora actual formateada
                LocalDateTime ahora = LocalDateTime .now ();
                String fechaActualFormateada = formatearFechaEspanol (ahora);
                System.out.println(" Fecha y hora actual del sistema: " + fechaActualFormateada );
                // 2. Pedir una fecha al usuario y mostrar el resultad formateado
                LocalDateTime fechaCita = leerYValidarFecha (scanner);
                System.out.println("Cita fijada para el: " + formatearFechaEspanol ( fechaCita ));
        }
    }
}