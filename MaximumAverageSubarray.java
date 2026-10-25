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

public class MaximumAverageSubarray {

    int numero;
    int k;
    int[] nums;

    FastReader reader = new FastReader();

    // Clase para leer los datos
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

        k = reader.nextInt();
    }

    // Encontrar el promedio maximo
    public void resuelve() {

        // Calcular la suma de los primeros k elementos
        long suma = 0;

        for (int i = 0; i < k; i++) {
            suma += nums[i];
        }

        long sumaMaxima = suma;

        // Deslizar la ventana por el arreglo
        for (int i = k; i < numero; i++) {

            suma = suma - nums[i - k] + nums[i];

            if (suma > sumaMaxima) {
                sumaMaxima = suma;
            }
        }

        // Calcular y mostrar el promedio maximo
        double promedio = (double) sumaMaxima / k;

        System.out.println(promedio);
    }

    public static void main(String[] args) {

        MaximumAverageSubarray id =
                new MaximumAverageSubarray();

        id.leerDatos();
        id.resuelve();
    }
}
