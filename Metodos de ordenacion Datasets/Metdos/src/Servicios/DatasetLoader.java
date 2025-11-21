package Servicios;

import modelos.Cita;
import modelos.Paciente;
import modelos.ItemInventario;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DatasetLoader {

    private static final String BASE_PATH =
            System.getProperty("user.dir") + "/src/datasets/";

    //cargar datasets de citas
    public static Cita[] cargarCitas100() throws IOException {
        return cargarCitas("citas_100.csv");
    }

    public static Cita[] cargarCitasCasiOrdenadas() throws IOException {
        return cargarCitas("citas_100_casi_ordenadas.csv");
    }

    private static Cita[] cargarCitas(String filename) throws IOException {

        Path path = Path.of(BASE_PATH + filename);
        List<String> lines = Files.readAllLines(path);

        // eliminar encabezado
        lines.remove(0);

        List<Cita> lista = new ArrayList<>();

        for (String l : lines) {
            if (l.isBlank()) continue;

            String[] p = l.split(";");
            String id = p[0];
            String apellido = p[1];
            LocalDateTime fechaHora = LocalDateTime.parse(p[2]);

            lista.add(new Cita(id, apellido, fechaHora));
        }

        return lista.toArray(new Cita[0]);
    }

    //cargar datasets de pacientes
    public static Paciente[] cargarPacientes() throws IOException {

        Path path = Path.of(BASE_PATH + "pacientes_500.csv");
        List<String> lines = Files.readAllLines(path);
        lines.remove(0);

        List<Paciente> lista = new ArrayList<>();

        for (String l : lines) {
            if (l.isBlank()) continue;

            String[] p = l.split(";");
            String id = p[0];
            String apellido = p[1];
            int prioridad = Integer.parseInt(p[2]);

            lista.add(new Paciente(id, apellido, prioridad));
        }

        return lista.toArray(new Paciente[0]);
    }

    //cargar datasets de inventario
    public static ItemInventario[] cargarInventarioInverso() throws IOException {

        Path path = Path.of(BASE_PATH + "inventario_500_inverso.csv");
        List<String> lines = Files.readAllLines(path);
        lines.remove(0);

        List<ItemInventario> lista = new ArrayList<>();

        for (String l : lines) {
            if (l.isBlank()) continue;

            String[] p = l.split(";");
            String id = p[0];
            String insumo = p[1];
            int stock = Integer.parseInt(p[2]);

            lista.add(new ItemInventario(id, insumo, stock));
        }

        return lista.toArray(new ItemInventario[0]);
    }
}
