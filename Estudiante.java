import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private String apellido;
    private int legajo;
    private int edad;
    private ArrayList<Double> calificaciones;

    public Estudiante(String nombre, String apellido, int legajo, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.edad = edad;
        this.calificaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getLegajo() {
        return legajo;
    }

    public int getEdad() {
        return edad;
    }

    public ArrayList<Double> getCalificaciones() {
        return calificaciones;
    }

    public void agregarCalificacion(double calificacion) {
        calificaciones.add(calificacion);
    }

    public double calcularPromedio() {
        double suma = 0;
        for (double calificacion : calificaciones) {
            suma += calificacion;
        }
        return calificaciones.isEmpty() ? 0 : suma / calificaciones.size();
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellido + ", Legajo: " + legajo + ", Edad: " + edad + ", Promedio: " + calcularPromedio();
    }
}
