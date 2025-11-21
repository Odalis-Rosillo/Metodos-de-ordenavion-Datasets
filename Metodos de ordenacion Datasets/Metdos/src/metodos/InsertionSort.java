package metodos;

public final class InsertionSort {
    public static void sort(int[] a) {
        // van los contadores
        int comparisons = 0;
        int swaps = 0;

        //si el arreglo esta vacio o solo tiene un valor
        //no hace nigun ordenamiento
        if (a == null || a.length <= 1) {
            return;
        }

        for (int i = 1; i < a.length; i++) {
            //guarda el valor que se va a insertar
            int valorActual = a[i];
            //empezamos a comparar hacia atrás
            int posicion = i - 1;

            //va moviendo los valores mayores hacia la derecha
            comparisons++;
            while (posicion >= 0 && a[posicion] > valorActual) {
                a[posicion + 1] = a[posicion];
                swaps++;
                posicion--;
                comparisons++;
            }
            //inserta el valor en la posicion correcta
            a[posicion + 1] = valorActual;
        }
    }

    public static void sort(int[] a, boolean trace) {
        if (!trace) {
            sort(a);
            return;
        }

        int comparisons = 0;
        int swaps = 0;

        if (a == null || a.length <= 1) {
            System.out.println("Array ya ordenado o vacío");
            return;
        }

        for (int i = 1; i < a.length; i++) {
            int valorActual = a[i];
            int posicion = i - 1;

            System.out.println("Iteración " + i + ": Insertando " + valorActual);

            comparisons++;
            while (posicion >= 0 && a[posicion] > valorActual) {
                a[posicion + 1] = a[posicion];
                swaps++;
                posicion--;
                comparisons++;
            }

            a[posicion + 1] = valorActual;
            System.out.println("Salida: " + arrayToString(a));
        }

        System.out.println("Array final: " + arrayToString(a));
        //presentar swaps y comparaciones
        System.out.println("Total swaps: " + swaps);
        System.out.println("Total comparisons: " + comparisons);
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