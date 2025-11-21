package datasets;

public class DatasetGeneratorDemo {
    public static void main(String[] args) throws Exception {

        new GeneratorCitas().generar();
        new GeneradorCitasCasiOrdenadas().generar();
        new GeneradorPacientes().generar();
        new GeneradorInventario().generar();

        System.out.println("Datasets generados correctamente.");
    }
}
