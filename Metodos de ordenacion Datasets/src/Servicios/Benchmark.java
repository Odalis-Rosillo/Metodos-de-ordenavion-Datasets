package Servicios;

import modelos.Cita;
import modelos.ItemInventario;
import modelos.Paciente;

public class Benchmark {

    public static void main(String[] args) throws Exception {

        System.out.println("______________________________________________________");
        System.out.println("benchmark de ordenamiento");
        System.out.println("______________________________________________________\n");

        //se carga los datasets

        Cita[] citas100 = DatasetLoader.cargarCitas100();
        Cita[] citasCasi = DatasetLoader.cargarCitasCasiOrdenadas();
        Paciente[] pacientes = DatasetLoader.cargarPacientes();
        ItemInventario[] inventario = DatasetLoader.cargarInventarioInverso();

        //convertir arreglos a claves

        long[] arrCitas = SortingUtils.convertirCitas(citas100);
        long[] arrCitasCasi = SortingUtils.convertirCitas(citasCasi);

        int[] arrPacientes = SortingUtils.convertirPacientes(pacientes);
        int[] arrInventario = SortingUtils.convertirInventario(inventario);


        imprimirResultados("Citas 100 (aleatorio)", arrCitas);
        imprimirResultados("Citas 100 casi ordenadas", arrCitasCasi);
        imprimirResultados("Pacientes 500 (duplicados)", arrPacientes);
        imprimirResultados("Inventario 500 inverso", arrInventario);

        System.out.println("=====================================================");
    }

    //para imprimir los resultados

    private static void imprimirResultados(String titulo, int[] base) {
        System.out.println("\n--- " + titulo + " ---");

        Stats bubble = SortingExperiment.correrBubble(base);
        Stats insertion = SortingExperiment.correrInsertion(base);
        Stats selection = SortingExperiment.correrSelection(base);

        System.out.printf("%-12s %-15s %-15s %-15s\n",
                "Algoritmo", "Comparisons", "Swaps", "Tiempo(ns)");
        System.out.println("----------------------------------------------------------");

        System.out.printf("%-12s %-15d %-15d %-15d\n",
                "Bubble", bubble.comparisons, bubble.swaps, bubble.tiempoNs);

        System.out.printf("%-12s %-15d %-15d %-15d\n",
                "Insertion", insertion.comparisons, insertion.swaps, insertion.tiempoNs);

        System.out.printf("%-12s %-15d %-15d %-15d\n",
                "Selection", selection.comparisons, selection.swaps, selection.tiempoNs);
    }

    private static void imprimirResultados(String titulo, long[] base) {
        System.out.println("\n--- " + titulo + " ---");

        // Convertimos long[] → int[] porque los algoritmos usan int[]
        int[] baseInt = new int[base.length];
        for (int i = 0; i < base.length; i++) baseInt[i] = (int) (base[i] % Integer.MAX_VALUE);

        imprimirResultados(titulo, baseInt);
    }
}
