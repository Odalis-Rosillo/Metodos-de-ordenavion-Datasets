package Servicios;

public class InstrumentedSorts {

    public static Stats bubbleSort(int[] a) {
        int[] arr = Servicios.SortingUtils.copiar(a);
        long comparisons = 0;
        long swaps = 0;

        long inicio = System.nanoTime();

        boolean huboIntercambio;
        for (int i = 0; i < arr.length - 1; i++) {
            huboIntercambio = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                comparisons++;
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swaps++;
                    huboIntercambio = true;
                }
            }
            if (!huboIntercambio) break;
        }

        long fin = System.nanoTime();

        return new Stats(fin - inicio, comparisons, swaps);
    }

    public static Stats insertionSort(int[] a) {
        int[] arr = Servicios.SortingUtils.copiar(a);
        long comparisons = 0;
        long swaps = 0;

        long inicio = System.nanoTime();

        for (int i = 1; i < arr.length; i++) {
            int actual = arr[i];
            int j = i - 1;
            comparisons++;
            while (j >= 0 && arr[j] > actual) {
                comparisons++;
                arr[j + 1] = arr[j];
                j--;
                swaps++;
            }
            arr[j + 1] = actual;
        }

        long fin = System.nanoTime();

        return new Stats(fin - inicio, comparisons, swaps);
    }

    public static Stats selectionSort(int[] a) {
        int[] arr = Servicios.SortingUtils.copiar(a);
        long comparisons = 0;
        long swaps = 0;

        long inicio = System.nanoTime();

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                comparisons++;
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
                swaps++;
            }
        }

        long fin = System.nanoTime();

        return new Stats(fin - inicio, comparisons, swaps);
    }
}
