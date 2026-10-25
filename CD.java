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

public class CD {
    FastReader reader = new FastReader();
    int N;       // Tamaño del arreglo
    int nums[];  // Arreglo de números

    static class FastReader {
        BufferedReader b;
        StringTokenizer s;

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return s.nextToken();
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
        Set<Integer> vistos = new HashSet<>();

        for (int i = 0; i < N; i++) {
            // Si el número ya está en el conjunto, encontramos un duplicado
            if (vistos.contains(nums[i])) {
                System.out.println("true (Contiene duplicados)");
                return;
            }
            // Si no está, lo agregamos al conjunto
            vistos.add(nums[i]);
        }

        // Si terminamos el ciclo sin retornar, todos son únicos
        System.out.println("false (No contiene duplicados)");
    }

    public static void main(String[] args) {
        CD c = new CD();
        c.leerDatos();
        c.resuelve();
    }
}
