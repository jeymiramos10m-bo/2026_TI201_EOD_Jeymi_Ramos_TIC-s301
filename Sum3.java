/*
*   FJMP-EDU 
*ITESS TIC´s 
*Estructura y Organizacion 
//Jeymi Jimena Ramos Martínez
//Pablo Zavala Carrillo
//copilador java ScoreBoardAPP.java
//test:java ScoreBoardAPP
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Sum3 {

    int numero;
    int[] nums;
    FastReader reader = new FastReader();

    // Clase FastReader para leer los datos
    static class FastReader {

        BufferedReader b;
        StringTokenizer s;

        public FastReader() {
            b = new BufferedReader(
                new InputStreamReader(System.in));
        }

        String next() {
            while (s == null || !s.hasMoreTokens()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return s.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        char nextChar() {
            return next().charAt(0);
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            try {
                s = null;
                return b.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Leer los datos de entrada
    public void leerDatos() {

        numero = reader.nextInt();
        nums = new int[numero];

        for (int i = 0; i < numero; i++) {
            nums[i] = reader.nextInt();
        }
    }

    // Resolver el problema 3Sum
    public void resuelve() {

        List<List<Integer>> resultado = new ArrayList<>();

        // Ordenar el arreglo
        Arrays.sort(nums);

        // Recorrer el arreglo
        for (int i = 0; i < numero - 2; i++) {

            // Evitar numeros iniciales repetidos
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int izquierda = i + 1;
            int derecha = numero - 1;

            // Buscar combinaciones de tres numeros
            while (izquierda < derecha) {

                long suma = (long) nums[i]
                          + nums[izquierda]
                          + nums[derecha];

                if (suma == 0) {

                    // Guardar la combinacion encontrada
                    List<Integer> tripleta = new ArrayList<>();

                    tripleta.add(nums[i]);
                    tripleta.add(nums[izquierda]);
                    tripleta.add(nums[derecha]);

                    resultado.add(tripleta);

                    izquierda++;
                    derecha--;

                    // Evitar tripletas duplicadas
                    while (izquierda < derecha
                            && nums[izquierda] == nums[izquierda - 1]) {
                        izquierda++;
                    }

                    while (izquierda < derecha
                            && nums[derecha] == nums[derecha + 1]) {
                        derecha--;
                    }

                } else if (suma < 0) {

                    // La suma es menor que cero
                    izquierda++;

                } else {

                    // La suma es mayor que cero
                    derecha--;
                }
            }
        }

        // Mostrar el resultado
        System.out.println(resultado);
    }

    public static void main(String[] args) {

        Sum3 id = new Sum3();

        id.leerDatos();
        id.resuelve();
    }
}
