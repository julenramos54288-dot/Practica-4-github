import java.util.Scanner;
import java.time. LocalDateTime ;
import java.time.format. DateTimeFormatter ;
import java.time.format. DateTimeParseException ;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         boolean salir = false;
         while (! salir) {
             System.out.println("\n--- GESTI´ON DE CITAS TALLER ---");
             System.out.println("1. Registrar nueva cita");
             System.out.println("2. Consultar citas por fecha");
             System.out.println("3. Calcular coste de servicio");
             System.out.println("4. Salir");
             System.out.print(" Seleccione una opci´on: ");

            int opcion = scanner.nextInt ();
             if (opcion == 4) {
                 salir = true;
                 System.out.println(" Saliendo del programa ...");
                 }
             }
    }
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