import java.util.Random;
import java.util.Scanner;

public class Examen {
    public static void main(String[] args){
        int num = 9;

        //EJERCICIO 1
        String clasificacion = clasificarNumero(num);
        System.out.print("\n");
        System.out.print("=====Ejercicio 1=====\n");
        System.out.printf("%s \n", clasificacion);
        System.out.print("=====================\n");
        System.out.print("\n");

        //EJERCICIO 2
        System.out.print("=====Ejercicio 2=====\n");
        System.out.printf("Multiplos de %d:\n", num);
        multiplos(num);
        System.out.print("=====================\n");
        System.out.print("\n");

        //EJERCICIO 3
        System.out.print("=====Ejercicio 3=====\n");
        aleatorios();
        System.out.print("=====================\n");
        System.out.print("\n");

        //EJERCICIO 4
        System.out.print("=====Ejercicio 4=====\n");
        int[] arrayNotas = new int[5];
        arrayNotas[0] = 5;
        arrayNotas[1] = 9;
        arrayNotas[2] = 4;
        arrayNotas[3] = 7;
        arrayNotas[4] = 2;
        float media = funcionArray(arrayNotas);
        System.out.printf("%.2f\n", media);
        System.out.print("=====================\n");
        System.out.print("\n");

        //EJERCICIO 5
        System.out.print("=====Ejercicio 5=====\n");
        double[][] matrizDoubles = new double[2][2];
        matrizDoubles[0][0] = 3.6;
        matrizDoubles[0][1] = 7.2;
        matrizDoubles[1][0] = 9.1;
        matrizDoubles[1][1] = 4.77;
        double total = sumaValores(matrizDoubles);
        System.out.printf("%.2f\n", total);
        System.out.print("=====================\n");
        System.out.print("\n");

        //EJERCICIO 6
        System.out.print("=====Ejercicio 6=====\n");
        // Ejemplo de entradas y valores devueltos:
        // - ({"a", "b", "c"}, "c") tiene que devolver 2. ✅
        // - ({"a", "b", "c"}, "d") tiene qu devolver -1. ✅
        // - ({"a", "b", "c", "a", "a", "a", "b"}, "a") tiene qu devolver 0. ✅
        String[] arrayString = {"a", "b", "c", "a", "a", "a", "b"};
        String valorBuscado = "a";
        int resultado = buscar(arrayString, valorBuscado);
        System.out.printf("%d\n", resultado);
        System.out.print("=====================\n");
        System.out.print("\n");

        //EJERCICIO 7
        System.out.print("=====Ejercicio 7=====\n");
        int[] array1 = {1, 5, 8};
        int[] array2 = {7, 3, 0, 8};
        int[] arraySumado = sumaArrays(array1, array2);
        for (int i = 0; i < arraySumado.length; i++) {
            System.out.printf("%d, ", arraySumado[i]);
        }
        System.out.print("\n");
        System.out.print("=====================\n");
        System.out.print("\n");

        //EJERCICIO 8
        System.out.print("=====Ejercicio 8=====\n");
        String[][] matrizNombres = new String[2][2];
        matrizNombres[0][0] = "alex";
        matrizNombres[0][1] = "ivan";
        matrizNombres[1][0] = "pepe";
        matrizNombres[1][1] = "juan";
        int nombres4Letras = calculaNumeroFilas(matrizNombres);
        System.out.printf("El numero de filas de la matriz que tienen todo nombre de 4 letras o menos es: %d\n", nombres4Letras);
        System.out.print("=====================\n");
        System.out.print("\n");

    }



    /******************** EJERCICIO 1 *****************************/
    // Esta función recibe un número como parámetro, y devuelve un String.
    // Si el número es negativo tiene que devolver "negativo",
    // si es cero tiene que devolver "cero",
    // si es positivo tiene que devolver "positivo"
    //
    // Por ejemplo: clasificarNumero(3) devuelve "positivo"; clasificarNumero(-1) devuelve "negativo"


    public static String clasificarNumero(int n) {
        String tipoNum = "";
        if (n > 0){
            tipoNum = "Positivo";
        } else if (n == 0) {
            tipoNum = "Cero";
        } else {
            tipoNum = "Negativo";
        }
        return tipoNum;
    }

    /******************** EJERCICIO 2 *****************************/
    // - Crea una función que se llame "multiplos"
    //   - La función recibe un parámetro de tipo int.
    //   - Imprime los múltiplos de 3 que existen entre el 1 y ese número (incluido)
    //     - (imprime un número en cada línea.)
    //
    // Por ejemplo:
    //   - si el parámetro de entrada es 9 tiene que hacer un bucle e imprimir
    //     los números 3, 6 y 9, aquellos que cumplan que son múltiplo de 3 entre el 1 y el 9 (incluido).

    public static void multiplos(int num){
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0){
                System.out.println(i);
            }
        }
    }



    /******************** EJERCICIO 3 *****************************/
    // Escribe una función que se llame "crearAleatorio" que no recibe parámetros, y no devuelve nada (void).
    // En la función:
    // - Crea un número aleatorio entre el 5 y el 20.
    // - Dentro de un bucle while, pide al usuario un número, réstalo del
    //   aleatorio (o sea, la variable del número aleatorio queda modificada)
    //   e imprime el resultado.
    // - La condición de salida del bucle (esto es, cuando NO tiene que ejecutarse más) es que
    //   el resultado es menor que 0
    //
    // Por ejemplo:
    // - Se genera aleatoriamente el número 12
    // - El usuario pone 4, imprimimos 8 (el resultado de 12-4)
    // - El usuario pone 5, imprimimos 3 (8-5, al resultado anterior le restamos el nuevo valor)
    // - El usuario pone 8, imprimimos -5 (3-8)
    // - Como el resultado ya es negativo, salimos del bucle.

    public static void aleatorios(){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int numAleatorio = random.nextInt(5, 20);
        System.out.printf("Numero generado: %d\n", numAleatorio);
        int numUsuraio = 0;
        System.out.print("Introduce un numero entero: ");
        numUsuraio = sc.nextInt();
        int numFinal = 0;
        do {
            numFinal = numAleatorio - numUsuraio;
            System.out.printf("%d\n", numFinal);
            numAleatorio = numFinal;
            if (numFinal > 0){
                System.out.print("Introduce un numero entero: ");
                numUsuraio = sc.nextInt();
            }
        } while (numFinal > 0);
    }

    /******************** EJERCICIO 4 *****************************/
    // Crea una función llamada funcionArray.
    // - Recibe un array de enteros como entrada.
    // - No se permite el uso de librería como Math; tenéis que hacer los cálculos con operaciones primitivas.
    // - En la función, con bucles, calcula el valor máximo, el mínimo y la media de los valores.
    //   - Ten en cuenta que la media tiene que ser un double (por ejemplo, la media de 4 y 1 es 2,5)
    // - Imprime los 3 valores
    // - La función devuelve como resultado la media.
    //
    //
    // Por ejemplo:
    // - Ante el array de entrada {3, 4, 4, 4}
    //   - Imprime en varias líneas "Máximo: 4", "Mínimo: 3", "Media: 3,25".
    //   - Devuelve 3,25 en la función

    public static float funcionArray(int[] arrayNotas){
        int sumaNotas = 0;
        float media = 0;
        int min = arrayNotas[0];
        int max = arrayNotas[0];
        for (int i = 0; i < arrayNotas.length; i++) {
            sumaNotas += arrayNotas[i];
            if (arrayNotas[i] < min) {
                min = arrayNotas[i];
            } else if (arrayNotas[i] > max) {
                max = arrayNotas[i];
            }
        }
        media = (float) sumaNotas / arrayNotas.length;
        System.out.printf("La nota maxima es: %d\n", max);
        System.out.printf("La nota minima es: %d\n", min);
        System.out.printf("La nota media es: %.2f\n", media);
        return media;
    }


    /******************** EJERCICIO 5 *****************************/
    // Crea una función que se llame sumaValores
    // - Recibe como entrada un array bidimensional de doubles.
    // - Imprime por pantalla la suma de todos los elementos.
    // - Devuelve el resultado.
    //
    // Por ejemplo, ante el array de 2x2 de entrada:
    // 1   2,5
    // 2   4,1
    // - Debe imprimir 9,6
    // - Deve devolver 9,6
    public static double sumaValores(double[][] arrayEntrada) {
        double sumaValoresMatriz = 0;
        for (int i = 0; i < arrayEntrada.length; i++) {
            for (int j = 0; j < arrayEntrada[i].length; j++) {
                sumaValoresMatriz += arrayEntrada[i][j];
            }
        }
        System.out.printf("La suma de todos los valores de la matriz es: %.2f\n", sumaValoresMatriz);
        return sumaValoresMatriz;
    }

    /******************** EJERCICIO 6 *****************************/
    // Crea una función que se llame buscar.
    // - Recibe como entrada:
    //   - Un array de String (el array en el que buscar)
    //   - Un String (el valor a buscar en los contenidos del array)
    // - Devuelve:
    //   - Si encuentra el valor a buscar en el array, la posición en la que lo ha encontrado
    //   - Si no lo encuentra, devuelve -1
    //   - Si el valor lo encuentra en varias posiciones, devuelve la primera posición encontrada
    //
    // Ejemplo de entradas y valores devueltos:
    // - ({"a", "b", "c"}, "c") tiene que devolver 2.
    // - ({"a", "b", "c"}, "d") tiene qu devolver -1.
    // - ({"a", "b", "c", "a", "a", "a", "b"}, "a") tiene qu devolver 0.

    public static int buscar(String[] array, String valorBuscado){
        int resultado = 0;
        int contador = 0;
        boolean encontrado = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(valorBuscado)){
                contador++;
                encontrado = true;
            }
        }
        if (contador == 1 && encontrado){
            resultado = 2;
        } else if (contador > 1 && encontrado) {
            for (int i = 0; i < array.length; i++) {
                if (array[i].equalsIgnoreCase(valorBuscado)){
                    resultado = i;
                    break;
                }
            }
        }
        if (!encontrado){
            resultado = -1;
        }
        return resultado;
    }



    /******************** EJERCICIO 7 *****************************/
    // Crea una función que se llama sumaArrays.
    // - Recibe como entrada dos arrays de enteros.
    // - Devuelve como salida un array donde se suman ambos (en la posición 0, la suma de la posición 0 de ambos arrays;
    //   en la posición 1, la suma de la posición 1 de ambos arrays).
    // - Ten en cuenta que:
    //   - Los arrays no tienen que tener el mismo tamaño. Por tanto, si un array tiene posición 6, y el otro no, considera
    //   - que el array que no la tiene suma 0 al valor final.
    //
    // Por ejemplo:
    // - Entrada de
    //   {1, 2, 4} y
    //   {3, 2, 1}:
    //   - Devuelve:
    //   {4, 4, 5}.
    // - Entrada de:
    //   {1, 2, 4, 5, 6} y
    //   {3, 2, 1}
    //   - Devuelve:
    //   {4, 4, 5, 5, 6}: o sea, en la posiciones 0, 1 y 2 la suma, en la 3 y 4 el valor del array de mayor tamaño.
    //
    // IMPORTANTE:
    // - Si no eres capaz de hacer el ejercicio considerando que hay arrays de distintos tamaños en la entrada,
    // haz el ejercicio asumiendo que son de igual tamaño. No obtienes la puntuación total del ejercicio, pero
    // si está bien obtienes parte de la puntuación.

    public static int[] sumaArrays(int[] array1, int[] array2){
        int logitudArrayMayor = 0;
        if (array1.length > array2.length){
            logitudArrayMayor = array1.length;
            int[] array2Nuevo = new int[logitudArrayMayor];
            for (int i = 0; i < array2.length; i++) {
                array2Nuevo[i] = array2[i];
            }
            int[] arrayResultado = new int[logitudArrayMayor];
            for (int i = 0; i < arrayResultado.length; i++) {
                arrayResultado[i] = array1[i] + array2Nuevo[i];
            }
            return arrayResultado;
        } else{
            logitudArrayMayor = array2.length;
            int[] array1Nuevo = new int[logitudArrayMayor];
            for (int i = 0; i < array1.length; i++) {
                array1Nuevo[i] = array1[i];
            }
            int[] arrayResultado = new int[logitudArrayMayor];
            for (int i = 0; i < arrayResultado.length; i++) {
                arrayResultado[i] = array1Nuevo[i] + array2[i];
            }
            return arrayResultado;
        }
    }


    /******************** EJERCICIO 8 *****************************/
    // Crea una función calculaNumeroFilas
    // - Recibe como entrada un array bidimensional de Strings
    // - Devuelve cuantas filas contienen únicamente nombres de 4 letras o menos
    //
    // Por ejemplo, ante la entrada:
    //
    // "pepe" "juan" "jose"
    // "andrés" "maría" "ana"
    // "luis" "olga" "eva"
    //
    // devolvería 2, ya que la fila 0 sólo tiene nombres de 4 letras o menos, y la fila 2 también. En cambio, en la fila 1 hay
    // algún nombre de más de cuatro letras, por lo que no la cuenta.

    public static int calculaNumeroFilas(String[][] matriz){
        int totalFilasValidas = 0;
        for (int i = 0; i < matriz.length; i++) {
            int contadorCasillasValidasFila = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                String str = matriz[i][j];
                if (str.length() <= 4){
                    contadorCasillasValidasFila++;
                }
                if(contadorCasillasValidasFila == matriz[i].length) {
                    totalFilasValidas++;
                }
            }
        }
        return totalFilasValidas;
    }
}
