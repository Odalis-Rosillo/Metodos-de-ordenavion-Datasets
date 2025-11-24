# DATASETS PARA BENCHMARK DE ORDENAMIENTO

### Integrantes: Odalis Rosillo & Richard Cajas

### Proyecto: Comparación de Métodos de Ordenación

-------------------------------------------
#1. CARACTERÍSTICAS GENERALES
-------------------------------------------
- Formato de archivo: CSV
- Codificación: UTF-8 (sin BOM)
- Separador de campos: punto y coma (;)
- Todos los archivos incluyen encabezado en la primera fila.
- Todos los datasets se generan con semilla fija:
  ▸ Semilla aleatoria utilizada: 42
  Esto garantiza reproducibilidad.

-------------------------------------------
#2. LISTA DE ARCHIVOS GENERADOS
-------------------------------------------
1) citas_100.csv
2) citas_100_casi_ordenadas.csv
3) pacientes_500.csv
4) inventario_500_inverso.csv

Ubicación de archivos:
Metodos de ordenacion Datasets/src/datasets/

-------------------------------------------
#3. DESCRIPCIÓN DE CADA DATASET
-------------------------------------------

--------------------------------------------------
3.1. citas_100.csv
--------------------------------------------------
Tamaño: 100 registros  
Campos: id;apellido;fechaHora  
Formato ID: CITA-001 … CITA-100  
Apellidos: tomados de un pool de 30 apellidos comunes (duplicados permitidos).  
Fecha y hora: generadas aleatoriamente entre:
▸ Fecha: 2025-03-01 y 2025-03-31
▸ Hora: entre 08:00 y 18:00
▸ Minutos: múltiplos de 10 (00,10,...50)
Distribución completamente aleatoria con semilla 42.

Ejemplo:
id;apellido;fechaHora
CITA-001;Guerrero;2025-03-05T10:40
CITA-002;Naranjo;2025-03-22T08:20

--------------------------------------------------
3.2. citas_100_casi_ordenadas.csv
--------------------------------------------------
Generado a partir de citas_100.csv, pero ordenado por fechaHora ascendente.

Luego se aplican exactamente 5 swaps pseudoaleatorios entre pares de filas:
▸ Equivale al 5% del total (requisito)
▸ No se repite ninguna pareja
▸ Semilla del generador aleatorio: 42

Esto produce un archivo "casi ordenado", ideal para favorecer InsertionSort.

Propósito: analizar rendimiento en datos casi ordenados.

--------------------------------------------------
3.3. pacientes_500.csv
--------------------------------------------------
Tamaño: 500 registros  
Campos: id;apellido;prioridad  
Formato ID: PAC-0001 … PAC-0500  
Apellidos: generados con sesgo estadístico:
▸ 60% comunes
▸ 30% medios
▸ 10% raros
Semilla: 42
Esto asegura gran cantidad de apellidos duplicados (útil para probar estabilidad).

Prioridad: entero en {1,2,3}, aleatorio con semilla 42.

Ejemplo:
id;apellido;prioridad
PAC-0001;Ramirez;1
PAC-0002;Ramirez;3

--------------------------------------------------
3.4. inventario_500_inverso.csv
--------------------------------------------------
Tamaño: 500 registros  
Campos: id;insumo;stock  
Formato ID: ITEM-0001 … ITEM-0500  
Insumo: nombres sintéticos realistas (rotan cada 10 ítems).  
Stock: valores estrictamente descendentes desde 500 hasta 1.

Propósito: simular caso completamente inverso al orden natural,
útil para comparar rendimiento de algoritmos cuando los datos
están en el peor estado para algunos métodos (Insertion y Bubble).

Ejemplo:

* ITEM-0001;Guante Nitrilo Talla M;500

* ITEM-0002;Alcohol 70% 1L;499

* ITEM-0003;Gasas 10x10;498

-------------------------------------------
#4. VALIDACIÓN FINAL
-------------------------------------------
Generación de 4 archivos  con nombres exactos.

Formato CSV con codificación UTF-8 y separador ;

Semilla fija = 42 en todos los generadores.

citas_100_casi_ordenadas.csv aplica 5 swaps exactos.

pacientes_500.csv contiene duplicados abundantes.

inventario_500_inverso.csv estrictamente descendente.

No hay filas vacías ni caracteres inválidos.

No se mezclan punto y coma dentro de los datos (reemplazado si aparece).


