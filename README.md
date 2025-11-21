# Métodos De Ordenación
Este es un proyecto Java que implementa tres algoritmos clásicos de ordenación: Insertion Sort, Bubble Sort y Selection Sort. Desarrollado como parte del Taller 5 de Estructura de Datos, incluye un sistema de trazas para visualizar el proceso de ordenación paso a paso. 
# Características Principales
Algoritmos Implementados
* InsertionSort: Ordena insertando elementos en su posición correcta
* BubbleSort: Ordena mediante intercambios adyacentes con corte temprano
* SelectionSort: Ordena seleccionando el mínimo elemento en cada iteración
# Requisitos Previos
* Java JDK 17 o superior
* Git para control de versiones
* IDE: IntelliJ IDEA, VS Code o cualquier editor Java
# Instalación
* Clona o descarga este repositorio en tu máquina local.
* Abrir el proyecto en tu IDE:
  * Importa como proyecto Java existente
  * Configura el JDK si es necesario
# Ejecución Básica
* Compila y ejecuta la clase principal sortingDemo
# Decisiones de Diseño 
Para la resolución de este taller, se opoto por seguir las siguientes decisiones de diseño: 
* Crear un paquete llamado métodos
  En este paquete va la lógica de algoritmos:
   * InsertionSort.java
   * BubbleSort.java
   * SelectionSort.java
* Crea un paquete llamado servicios
  En este paquete van las pruebas con las clases:
   * SortingDemo.java
   * SortingUtils.java
* Realizar la sobrecaraga de métodos sort(array) y sort(array, true) para trazas
# Flujo de uso
* El programa ejecuta automáticamente los 3 algoritmos con 5 datasets diferentes
* Muestra el proceso paso a paso para cada algoritmo
* Incluye arrays iniciales, iteraciones intermedias y resultados finales
# Casos Bordes 
Los casos bordes que se manejan son: 
* Array vacío	[]	: Retorna inmediatamente
* Un elemento	[5]	: Considerado ordenado
* Ya ordenado	[1,2,3,4,5]	: Eficiencia optimizada
* Orden inverso	[5,4,3,2,1]	: Peor caso de rendimiento
* Elementos iguales	[2,2,2,2]	: Mantiene estabilidad
* Array null	null	: Manejo seguro de errores
