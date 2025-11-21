package datasets;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class GeneradorCitasCasiOrdenadas extends DatasetGenerator {

    public void generar() throws Exception {

        List<String> lineas = Files.readAllLines(Path.of(BASE_PATH + "citas_100.csv"));
        String header = lineas.remove(0);

        // ordenar por fechaHora ascendente
        lineas.sort(Comparator.comparing(l -> l.split(";")[2]));

        Random rnd = new Random(42);
        Set<String> intercambiados = new HashSet<>();

        for (int k = 0; k < 5; k++) {
            int i, j;
            do {
                i = rnd.nextInt(lineas.size());
                j = rnd.nextInt(lineas.size());
            } while (i == j || intercambiados.contains(i + "-" + j));

            intercambiados.add(i + "-" + j);

            // swap
            String temp = lineas.get(i);
            lineas.set(i, lineas.get(j));
            lineas.set(j, temp);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(header).append("\n");
        lineas.forEach(l -> sb.append(l).append("\n"));

        escribirCSV("citas_100_casi_ordenadas.csv", sb.toString());
    }
}
