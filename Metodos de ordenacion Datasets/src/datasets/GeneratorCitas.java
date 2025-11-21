package datasets;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Random;

public class GeneratorCitas extends DatasetGenerator {

    public void generar() throws Exception {
        Random rnd = new Random(42);

        String[] apellidos = {
                "Guerrero","Naranjo","Cedeño","Rosillo","Calle","Vera","Maldonado",
                "Torres","García","Lozano","Ortiz","Aguirre","Ramos","Gómez",
                "Sánchez","Rojas","Ávila","Pérez","Jiménez","Moreno","Villalba",
                "Salazar","Molina","Zambrano","Castillo","Moreira","Suárez",
                "Vinueza","Flores","Benítez"
        };

        LocalDate inicio = LocalDate.of(2025, 3, 1);
        LocalDate fin = LocalDate.of(2025, 3, 31);

        StringBuilder sb = new StringBuilder();
        sb.append("id;apellido;fechaHora\n");

        for (int i = 1; i <= 100; i++) {
            String id = String.format("CITA-%03d", i);
            String apellido = apellidos[rnd.nextInt(apellidos.length)];

            long daysRange = fin.toEpochDay() - inicio.toEpochDay();
            LocalDate fecha = inicio.plusDays(rnd.nextInt((int) daysRange + 1));

            int minuto = rnd.nextInt(6) * 10; // valores válidos: 0,10,20,30,40,50
            int hora = rnd.nextInt(11) + 8; // 08 a 18

            LocalDateTime fechaHora = LocalDateTime.of(fecha, LocalTime.of(hora, minuto));

            sb.append(id).append(";")
                    .append(apellido).append(";")
                    .append(fechaHora).append("\n");
        }

        escribirCSV("citas_100.csv", sb.toString());
    }
}
