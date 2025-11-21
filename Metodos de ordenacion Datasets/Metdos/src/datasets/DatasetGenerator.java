package datasets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class DatasetGenerator {

    protected static final String BASE_PATH = "Metdos/src/datasets/";

    protected void escribirCSV(String filename, String contenido) throws IOException {

        // Asegurar que el directorio exista
        Path dir = Path.of(BASE_PATH);
        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }

        // Ruta del archivo
        Path path = dir.resolve(filename);

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(path.toFile(), StandardCharsets.UTF_8))) {
            bw.write(contenido);
        }
    }
}
