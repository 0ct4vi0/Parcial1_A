package org.example;

import java.util.Random;
import java.util.Scanner;

public class ParcialJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar;
        do {
            // Paso 1: Solicitar la dimensión de la matriz
            int dimension = solicitarDimension(sc);

            // Paso 2: Crear y completar la matriz
            int[][] matriz = crearMatriz(dimension, sc);

            // Paso 3: Mostrar la matriz generada
            System.out.println("Matriz generada:");
            mostrarMatriz(matriz);

            // Paso 4: Obtener valores centrales
            int[] valoresCentrales = obtenerValoresCentrales(matriz);

            // Paso 5: Mostrar los valores centrales
            System.out.println("Valores centrales:");
            mostrarArray(valoresCentrales);

            // Paso 6: Ordenar la matriz de valores centrales con burbuja
            ordenarBurbuja(valoresCentrales);

            // Paso 7: Mostrar la matriz ordenada
            System.out.println("Valores centrales ordenados:");
            mostrarArray(valoresCentrales);

            // Paso 8: Calcular y mostrar los promedios
            double promedioFinal = calcularPromedioDeMatrices(matriz, valoresCentrales);

            System.out.println("El promedio de ambas matrices es: " + promedioFinal);

            // Paso 9: Preguntar si desea continuar
            continuar = deseaContinuar(sc);

        } while (continuar);
        System.out.println("Programa finalizado.");
    }
    // Paso 1: Solicitar dimensión de la matriz
    public static int solicitarDimension(Scanner sc) {
        int dimension;
        do {
            System.out.print("Ingrese la dimensión impar de la matriz (entre 3 y 15): ");
            dimension = sc.nextInt();
        } while (dimension < 3 || dimension > 15 || dimension % 2 == 0);
        return dimension;
    }

    // Paso 2: Crear la matriz y completarla
    public static int[][] crearMatriz(int dimension, Scanner sc) {
        int[][] matriz = new int[dimension][dimension];
        Random random = new Random();

        // Llenar última fila manualmente
        System.out.println("Ingrese los valores de la última fila (entre 10 y 99):");
        for (int i = 0; i < dimension; i++) {
            do {
                System.out.print("Valor [" + (dimension - 1) + "][" + i + "]: ");
                matriz[dimension - 1][i] = sc.nextInt();
            } while (matriz[dimension - 1][i] < 10 || matriz[dimension - 1][i] > 99);
        }

        // Llenar el resto de la matriz con valores aleatorios
        for (int i = 0; i < dimension - 1; i++) {
            for (int j = 0; j < dimension; j++) {
                matriz[i][j] = random.nextInt(90) + 10; // Entre 10 y 99
            }
        }
        return matriz;
    }

    // Paso 3: Mostrar la matriz
    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + "\t");
            }
            System.out.println();
        }
    }

    // Paso 4: Obtener valores centrales
    public static int[] obtenerValoresCentrales(int[][] matriz) {
        int dimension = matriz.length;
        int centro = dimension / 2;
        int[] valoresCentrales = new int[9];
        int index = 0;

        // Extraer el valor central y los colindantes
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                valoresCentrales[index++] = matriz[centro + i][centro + j];
            }
        }
        return valoresCentrales;
    }

    // Paso 5: Mostrar los valores centrales
    public static void mostrarArray(int[] array) {
        for (int valor : array) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }

    // Paso 6: Ordenar con método de burbuja
    public static void ordenarBurbuja(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Paso 8: Calcular promedio de matrices
    public static double calcularPromedioDeMatrices(int[][] matriz, int[] valoresCentrales) {
        int sumaMatriz = 0, elementosMatriz = 0;
        int sumaCentrales = 0;

        // Sumar todos los elementos de la matriz
        for (int[] fila : matriz) {
            for (int valor : fila) {
                sumaMatriz += valor;
                elementosMatriz++;
            }
        }

        // Sumar los valores centrales
        for (int valor : valoresCentrales) {
            sumaCentrales += valor;
        }

        // Calcular promedios
        double promedioMatriz = (double) sumaMatriz / elementosMatriz;
        double promedioCentrales = (double) sumaCentrales / valoresCentrales.length;

        // Mostrar resultados
        System.out.println("Suma total de la matriz: " + sumaMatriz);
        System.out.println("Cantidad de elementos en la matriz: " + elementosMatriz);
        System.out.println("Promedio de la matriz: " + promedioMatriz);

        System.out.println("Suma total de los valores centrales: " + sumaCentrales);
        System.out.println("Cantidad de valores centrales: " + valoresCentrales.length);
        System.out.println("Promedio de los valores centrales: " + promedioCentrales);

        // Promedio final
        return (promedioMatriz + promedioCentrales) / 2;
    }

    // Paso 9: Preguntar si desea continuar
    public static boolean deseaContinuar(Scanner sc) {
        System.out.print("¿Desea iniciar nuevamente la ejecución del programa? (SI/NO): ");
        String respuesta = sc.next();
        return respuesta.equalsIgnoreCase("SI");
    }
}
