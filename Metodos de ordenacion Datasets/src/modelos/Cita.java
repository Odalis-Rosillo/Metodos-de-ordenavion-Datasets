package modelos;

import java.time.LocalDateTime;

public class Cita {

    private final String id;
    private final String apellido;
    private final LocalDateTime fechaHora;

    public Cita(String id, String apellido, LocalDateTime fechaHora) {
        this.id = id;
        this.apellido = apellido;
        this.fechaHora = fechaHora;
    }

    public String getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    // clave de ordenamiento
    public LocalDateTime clave() {
        return fechaHora;
    }

    @Override
    public String toString() {
        return id + " - " + apellido + " - " + fechaHora;
    }
}
