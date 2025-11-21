package datasets;

public class GeneradorInventario extends DatasetGenerator {

    private static final String[] INSUMOS = {
            "Guante Nitrilo Talla M",
            "Alcohol 70% 1L",
            "Gasas 10x10",
            "Jeringuilla 5ml",
            "Mascarilla quirúrgica",
            "Bata descartable",
            "Algodón paquete 500g",
            "Termómetro digital",
            "Venda elástica 5cm",
            "Suero fisiológico 500ml"
    };

    public void generar() throws Exception {

        StringBuilder sb = new StringBuilder();
        sb.append("id;insumo;stock\n");

        int stock = 500;

        for (int i = 1; i <= 500; i++) {
            String id = String.format("ITEM-%04d", i);
            String insumo = INSUMOS[(i - 1) % INSUMOS.length];

            // aseguramos que no haya ';'
            insumo = insumo.replace(";", ",");

            sb.append(id).append(";")
                    .append(insumo).append(";")
                    .append(stock--).append("\n");
        }

        escribirCSV("inventario_500_inverso.csv", sb.toString());
    }
}
