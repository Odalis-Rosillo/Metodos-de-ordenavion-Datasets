package modelos;

public class Paciente {

    private final String id;
    private final String apellido;
    private final int prioridad;

    public Paciente(String id, String apellido, int prioridad) {
        this.id = id;
        this.apellido = apellido;
        this.prioridad = prioridad;
    }

    public String getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public int getPrioridad() {
        return prioridad;
    }

    // clave para el ordenamiento
    public String clave() {
        return apellido;
    }

    @Override
    public String toString() {
        return id + " - " + apellido + " - " + prioridad;
    }
}
