package Servicios;

import java.util.Arrays;

public class SortingExperiment {

    private static final int R = 10;   // total corridas
    private static final int WARMUP = 3; // corridas descartadas

    public static Stats correrBubble(int[] base) {
        return correrExperimento(base, "bubble");
    }

    public static Stats correrInsertion(int[] base) {
        return correrExperimento(base, "insertion");
    }

    public static Stats correrSelection(int[] base) {
        return correrExperimento(base, "selection");
    }

    private static Stats correrExperimento(int[] base, String metodo) {

        long[] tiempos = new long[R];
        long[] comps = new long[R];
        long[] swaps = new long[R];

        for (int i = 0; i < R; i++) {

            Stats s;

            switch (metodo) {
                case "bubble" -> s = InstrumentedSorts.bubbleSort(base);
                case "insertion" -> s = InstrumentedSorts.insertionSort(base);
                case "selection" -> s = InstrumentedSorts.selectionSort(base);
                default -> throw new IllegalArgumentException("Método no válido");
            }

            tiempos[i] = s.tiempoNs;
            comps[i] = s.comparisons;
            swaps[i] = s.swaps;
        }

        // Eliminamos las primeras 3 corridas
        long[] tiemposFiltrados = Arrays.copyOfRange(tiempos, WARMUP, R);
        long[] compsFiltrados = Arrays.copyOfRange(comps, WARMUP, R);
        long[] swapsFiltrados = Arrays.copyOfRange(swaps, WARMUP, R);

        Arrays.sort(tiemposFiltrados);
        Arrays.sort(compsFiltrados);
        Arrays.sort(swapsFiltrados);

        // Mediana
        long tiempoMediana = tiemposFiltrados[tiemposFiltrados.length / 2];
        long compsMediana = compsFiltrados[compsFiltrados.length / 2];
        long swapsMediana = swapsFiltrados[swapsFiltrados.length / 2];

        return new Stats(tiempoMediana, compsMediana, swapsMediana);
    }
}
