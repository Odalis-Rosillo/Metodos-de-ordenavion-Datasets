package datasets;

import java.util.Random;

public class GeneradorPacientes extends DatasetGenerator {

    public void generar() throws Exception {
        Random rnd = new Random(42);

        // pool de 50 pero dividido en grupos con probabilidad sesgada
        String[] comunes = {
                "Ramírez","Cedeño","Guerrero","Sánchez","Pérez","Molina","Moreira",
                "Torres","Gómez","Rojas","Jiménez","Ávila","Rosillo","Calle",
                "Flores","Vera","Maldonado","Benítez","Castillo","Lozano"
        };
        String[] medios = {
                "Zambrano","Aguirre","Salazar","Ramos","López","Villalba",
                "Suárez","Zamora","Medina","Cornejo","Moreno","Cárdenas"
        };
        String[] raros = {
                "Quishpe","Lliguizaca","Chilán","Alcívar","Chávez"
        };

        StringBuilder sb = new StringBuilder();
        sb.append("id;apellido;prioridad\n");

        for (int i = 1; i <= 500; i++) {

            String id = String.format("PAC-%04d", i);

            // distribución de apellidos: 60% comunes, 30% medios, 10% raros
            int p = rnd.nextInt(100);
            String apellido = (p < 60)
                    ? comunes[rnd.nextInt(comunes.length)]
                    : (p < 90)
                    ? medios[rnd.nextInt(medios.length)]
                    : raros[rnd.nextInt(raros.length)];

            int prioridad = rnd.nextInt(3) + 1;  // 1,2,3

            sb.append(id).append(";")
                    .append(apellido).append(";")
                    .append(prioridad).append("\n");
        }

        escribirCSV("pacientes_500.csv", sb.toString());
    }
}
