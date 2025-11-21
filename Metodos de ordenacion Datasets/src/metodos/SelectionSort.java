package metodos;

public final class SelectionSort {
    public static void sort(int[] a) {
        sort(a, false);
    }

    public static void sort(int[] a, boolean trace) {
        int n = a.length; // Tamaño del arreglo

        //van los contadores
        int swaps = 0;
        int comparisons = 0;

        //si el arreglo esta vacio muestra:
        if (a == null || a.length <= 1) {
            System.out.println("Array ya ordenado o vacío");
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            int minimo = i; // Toma al valor en i como minimo

            // Busca el valor minimo
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (a[j] < a[minimo]) {
                    //el nuevo minimo
                    minimo = j;
                }
            }

            if (trace) {
                System.out.println("Iteración #" + (i+1) + ": Selecionando " + a[minimo]);
            }

            //Compara y reorganiza
            if (minimo != i) {
                int temp = a[i];
                a[i] = a[minimo];
                a[minimo] = temp;
                swaps++;
            }

            if (trace) {
                System.out.println("Salida: " + arrayToString(a));
            }
        }

        if(trace){
            System.out.println("Array final: " + java.util.Arrays.toString(a));
            System.out.println("Total Swaps: " + swaps);
            System.out.println("Total Comparisons: " + comparisons);
        }
    }

    // para mostrar el arreglo de mejor forma
    private static String arrayToString(int[] a) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            if (i < a.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}