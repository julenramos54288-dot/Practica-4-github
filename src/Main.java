import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- GESTIÓN DE CITAS TALLER ---");
            System.out.println("1. Registrar nueva cita");
            System.out.println("2. Consultar citas por fecha");
            System.out.println("3. Calcular coste de servicio");
            System.out.println("4. Probar formato de fecha");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Debe introducir un número.");
                scanner.nextLine();
                continue;
            }

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea

            switch (opcion) {
                case 1:
                    String matricula = pedirDatosDelVehiculo(scanner);
                    LocalDate fecha = pedirFechaCita(scanner);
                    System.out.println("Vehículo: " + matricula);
                    System.out.println("Fecha de la cita: " + fecha);
                    System.out.println("Datos validados. Este ejemplo todavía no guarda la cita.");
                    break;
                case 2:
                    System.out.println("La consulta por fecha necesita una lista de citas guardadas.");
                    break;
                case 3:
                    probarCalculoCoste(scanner);
                    break;
                case 4:
                    probarFormatoFecha(scanner);
                    break;
                case 5:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Elija del 1 al 5.");
            }
        }

        scanner.close();
    }

    public static double calcularCosteServicio(int tipoServicio, String matricula) {
        double precioBase;

        switch (tipoServicio) {
            case 1:
                precioBase = 50.0; // Cambio de aceite y filtro
                break;
            case 2:
                precioBase = 120.0; // Revisión general / Pre-ITV
                break;
            case 3:
                precioBase = 200.0; // Cambio de frenos y discos
                break;
            case 4:
                precioBase = 350.0; // Reparación de distribución
                break;
            default:
                System.out.println("Opción de servicio no válida. Se aplicará tarifa estándar.");
                precioBase = 80.0;
                break;
        }

        String matriculaLimpia = matricula.trim().toUpperCase(Locale.ROOT);
        double porcentajeDescuento = 0.0;

        if (matriculaLimpia.endsWith("ECO")) {
            porcentajeDescuento = 0.20;
            System.out.println("Aplicado 20 % de descuento por matrícula ECO.");
        } else if (matriculaLimpia.contains("00")) {
            porcentajeDescuento = 0.10;
            System.out.println("Aplicado 10 % de descuento por promoción especial (serie 00).");
        } else if (matriculaLimpia.startsWith("H")) {
            porcentajeDescuento = 0.15;
            System.out.println("Aplicado 15 % de descuento para vehículo histórico.");
        } else {
            System.out.println("No se aplican descuentos a esta matrícula.");
        }

        double descuento = precioBase * porcentajeDescuento;
        return precioBase - descuento;
    }

    public static void probarCalculoCoste(Scanner scanner) {
        System.out.println("\n--- CÁLCULO DE COSTE DE SERVICIO ---");
        System.out.println("1. Cambio de aceite y filtro (50 €)");
        System.out.println("2. Revisión general (120 €)");
        System.out.println("3. Cambio de frenos (200 €)");
        System.out.println("4. Distribución (350 €)");
        System.out.print("Seleccione el tipo de servicio: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Debe introducir un número.");
            scanner.nextLine();
            return;
        }

        int opcionServicio = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introduzca la matrícula del vehículo (ej. 1234 ECO, H1234BBB, 0012 KFX): ");
        String matriculaInput = scanner.nextLine();

        double total = calcularCosteServicio(opcionServicio, matriculaInput);
        System.out.printf(Locale.ROOT, "El importe total a pagar es: %.2f €%n", total);
    }

    public static String pedirDatosDelVehiculo(Scanner scanner) {
        Pattern patron = Pattern.compile("^[0-9]{4}\\s?[BCDFGHJKLMNPRSTVWXYZ]{3}$");
        String matricula;

        while (true) {
            System.out.print("Introduce la matrícula de tu coche (ej. 1234 ABC): ");
            matricula = scanner.nextLine().trim().toUpperCase(Locale.ROOT);
            Matcher matcher = patron.matcher(matricula);

            if (matcher.matches()) {
                return matricula;
            }

            System.out.println("Matrícula no válida. Usa 4 números y 3 letras, por ejemplo 1234 ABC.");
        }
    }

    public static LocalDate pedirFechaCita(Scanner scanner) {
        while (true) {
            System.out.print("Introduce la fecha de la cita (AAAA-MM-DD): ");
            String fecha = scanner.nextLine().trim();

            try {
                return LocalDate.parse(fecha);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha no válida. Usa el formato AAAA-MM-DD, por ejemplo 2026-10-27.");
            }
        }
    }

    public static class GestorFechas {
        private static final String PATRON_FECHA = "dd/MM/yyyy HH:mm";
        private static final DateTimeFormatter FORMATO_ESPANOL =
                DateTimeFormatter.ofPattern(PATRON_FECHA, new Locale("es", "ES"));

        public static String formatearFechaEspanol(LocalDateTime fechaHora) {
            if (fechaHora == null) {
                return "Fecha no disponible";
            }
            return fechaHora.format(FORMATO_ESPANOL);
        }

        public static LocalDateTime leerYValidarFecha(Scanner scanner) {
            while (true) {
                System.out.print("Introduzca la fecha y hora de la cita (" + PATRON_FECHA + "): ");
                String entrada = scanner.nextLine().trim();

                try {
                    LocalDateTime fechaParseada =
                            LocalDateTime.parse(entrada, FORMATO_ESPANOL);
                    System.out.println("Fecha registrada correctamente.");
                    return fechaParseada;
                } catch (DateTimeParseException e) {
                    System.out.println("Formato incorrecto. Debe usar dd/MM/yyyy HH:mm (ej. 27/10/2026 14:30).");
                }
            }
        }
    }

    public static void probarFormatoFecha(Scanner scanner) {
        System.out.println("\n--- CONSULTA Y REGISTRO DE FECHAS ---");
        LocalDateTime ahora = LocalDateTime.now();
        System.out.println("Fecha y hora actual del sistema: "
                + GestorFechas.formatearFechaEspanol(ahora));

        LocalDateTime fechaCita = GestorFechas.leerYValidarFecha(scanner);
        System.out.println("Cita fijada para el: "
                + GestorFechas.formatearFechaEspanol(fechaCita));
    }
}