package Servicios;

import modelos.Cita;
import modelos.ItemInventario;
import modelos.Paciente;

public class SortingUtils {

    // ---------------------------
    // CITA → arreglo long[] (fechaHora)
    // ---------------------------
    public static long[] convertirCitas(Cita[] citas) {
        long[] arr = new long[citas.length];
        for (int i = 0; i < citas.length; i++) {
            arr[i] = citas[i].getFechaHora().atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli();
        }
        return arr;
    }

    // ---------------------------
    // PACIENTE → arreglo String[] (apellido)
    // Convertimos String → int mediante hash estable
    // ---------------------------
    public static int[] convertirPacientes(Paciente[] pacientes) {
        int[] arr = new int[pacientes.length];
        for (int i = 0; i < pacientes.length; i++) {
            arr[i] = pacientes[i].getApellido().hashCode();
        }
        return arr;
    }

    // ---------------------------
    // INVENTARIO → arreglo int[] (stock)
    // ---------------------------
    public static int[] convertirInventario(ItemInventario[] items) {
        int[] arr = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            arr[i] = items[i].getStock();
        }
        return arr;
    }

    // ---------------------------
    // Clonación profunda de arreglos
    // Para no alterar el original en los experimentos
    // ---------------------------
    public static int[] copiar(int[] arr) {
        int[] nuevo = new int[arr.length];
        System.arraycopy(arr, 0, nuevo, 0, arr.length);
        return nuevo;
    }

    public static long[] copiar(long[] arr) {
        long[] nuevo = new long[arr.length];
        System.arraycopy(arr, 0, nuevo, 0, arr.length);
        return nuevo;
    }
}
