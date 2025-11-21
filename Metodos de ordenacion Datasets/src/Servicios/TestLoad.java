package Servicios;

import Servicios.DatasetLoader;
import modelos.Cita;
import modelos.ItemInventario;
import modelos.Paciente;

//clase para verificar que se cargaron los datasets
public class TestLoad {
    public static void main(String[] args) throws Exception {

        Cita[] citas = DatasetLoader.cargarCitas100();
        System.out.println("Citas cargadas: " + citas.length);

        Paciente[] pacientes = DatasetLoader.cargarPacientes();
        System.out.println("Pacientes: " + pacientes.length);

        ItemInventario[] inventario = DatasetLoader.cargarInventarioInverso();
        System.out.println("Inventario: " + inventario.length);
    }
}

