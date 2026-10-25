/*
-   FJMP-EDU @ 2026
-   ITESS 
-   Periodo Agosto Diciembre 2026
-   Jeymi Jimena Ramos Martínez
-   Pablo Zavala Carrillo
-   Plantilla de configuración ICPC java (Adaptada para Two Sum)
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class LongestConsecutive {
    FastReader reader = new FastReader();
    int N;       // Tamaño del arreglo
    int nums[];  // Arreglo de números

    static class FastReader {
        BufferedReader b;
        StringTokenizer st;

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public void leerDatos() {
        N = reader.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = reader.nextInt();
        }
    }

    public void resuelve() {
        if (N == 0) {
            System.out.println("Longitud máxima: 0");
            return;
        }

        // Paso 1: Agregar todos los elementos a un HashSet
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longitudMaxima = 0;

        // Paso 2: Buscar secuencias
        for (int num : numSet) {
            // Verificamos si es el inicio de una secuencia (si no existe el anterior)
            if (!numSet.contains(num - 1)) {
                int actualNum = num;
                int actualLongitud = 1;

                // Contamos cuántos números consecutivos hacia adelante existen
                while (numSet.contains(actualNum + 1)) {
                    actualNum++;
                    actualLongitud++;
                }

                // Actualizamos la longitud máxima encontrada
                longitudMaxima = Math.max(longitudMaxima, actualLongitud);
            }
        }

        System.out.println("Longitud de la secuencia consecutiva más larga: " + longitudMaxima);
    }

    public static void main(String[] args) {
        LongestConsecutive c = new LongestConsecutive();
        c.leerDatos();
        c.resuelve();
    }
}