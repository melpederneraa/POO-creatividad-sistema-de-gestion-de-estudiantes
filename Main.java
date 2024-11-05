import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("Menú:");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Agregar Calificación a un Estudiante");
            System.out.println("3. Buscar Estudiante por Nombre");
            System.out.println("4. Mostrar Todos los Estudiantes");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    // Agregar Estudiante
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Legajo: ");
                    int legajo = scanner.nextInt();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    estudiantes.add(new Estudiante(nombre, apellido, legajo, edad));
                    System.out.println("Estudiante agregado.");
                    break;
                case 2:
              
                    System.out.print("Introduce el legajo del estudiante: ");
                    int legajoBuscar = scanner.nextInt();
                    Estudiante estudianteEncontrado = buscarEstudiantePorLegajo(estudiantes, legajoBuscar);
                    if (estudianteEncontrado != null) {
                        System.out.print("Calificación a agregar: ");
                        double calificacion = scanner.nextDouble();
                        estudianteEncontrado.agregarCalificacion(calificacion);
                        System.out.println("Calificación agregada.");
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;
                case 3:
                  
                    System.out.print("Introduce el nombre del estudiante: ");
                    String nombreBuscar = scanner.nextLine();
                    buscarEstudiantePorNombre(estudiantes, nombreBuscar);
                    break;
                case 4:
                    // Mostrar Todos los Estudiantes
                    for (Estudiante est : estudiantes) {
                        System.out.println(est);
                    }
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Programa finalizado.");
    }

   
    public static Estudiante buscarEstudiantePorLegajo(ArrayList<Estudiante> estudiantes, int legajo) {
        for (Estudiante est : estudiantes) {
            if (est.getLegajo() == legajo) {
                return est;
            }
        }
        return null; // Si no se encuentra, retorna null
    }

   
    public static void buscarEstudiantePorNombre(ArrayList<Estudiante> estudiantes, String nombre) {
        boolean encontrado = false;
        for (Estudiante est : estudiantes) {
            if (est.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(est);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró ningún estudiante con el nombre: " + nombre);
        }
    }
}
