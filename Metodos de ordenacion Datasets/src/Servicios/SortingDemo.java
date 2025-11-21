package Servicios;

import modelos.Cita;

public class SortingDemo {

    public static void main(String[] args) throws Exception {

        System.out.println("=== DEMO RÁPIDA ===");

        // cargar dataset de prueba
        Cita[] citas = DatasetLoader.cargarCitas100();

        // convertir a claves
        long[] claves = SortingUtils.convertirCitas(citas);

        // long[] → int[] para los algoritmos
        int[] arr = new int[claves.length];
        for (int i = 0; i < claves.length; i++) {
            arr[i] = (int) (claves[i] % Integer.MAX_VALUE);
        }

        System.out.println("\n--------------------------------------");
        System.out.println("         Comparación rápida           ");
        System.out.println("--------------------------------------\n");

        // Bubble
        Stats bubble = SortingExperiment.correrBubble(arr);
        System.out.println("BubbleSort:");
        System.out.println("  Comparisons = " + bubble.comparisons);
        System.out.println("  Swaps       = " + bubble.swaps);
        System.out.println("  Tiempo(ns)  = " + bubble.tiempoNs);
        System.out.println();

        // Insertion
        Stats insertion = SortingExperiment.correrInsertion(arr);
        System.out.println("InsertionSort:");
        System.out.println("  Comparisons = " + insertion.comparisons);
        System.out.println("  Swaps       = " + insertion.swaps);
        System.out.println("  Tiempo(ns)  = " + insertion.tiempoNs);
        System.out.println();

        // Selection
        Stats selection = SortingExperiment.correrSelection(arr);
        System.out.println("SelectionSort:");
        System.out.println("  Comparisons = " + selection.comparisons);
        System.out.println("  Swaps       = " + selection.swaps);
        System.out.println("  Tiempo(ns)  = " + selection.tiempoNs);
        System.out.println();

        System.out.println("=== FIN DEMO ===");
    }
}
