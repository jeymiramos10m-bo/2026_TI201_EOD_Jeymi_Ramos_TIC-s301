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
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class TwoSom {
    FastReader reader = new FastReader();
    int N;       // Cantidad de números en el arreglo
    int target;  // El número objetivo que queremos alcanzar con la suma
    int nums[];  // El arreglo de números

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
        // Leemos N (tamaño del arreglo) y el target (objetivo)
        N = reader.nextInt();
        target = reader.nextInt();

        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = reader.nextInt();
        }
    }

    public void resuelve() {
        // Mapa para guardar <Valor, Índice>
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int complemento = target - nums[i];

            // Si el complemento ya está en el mapa, encontramos la pareja
            if (map.containsKey(complemento)) {
                System.out.println("Índices: " + map.get(complemento) + " y " + i);
                System.out.println("Valores: " + nums[map.get(complemento)] + " + " + nums[i] + " = " + target);
                return; // Terminamos al encontrar la primera solución
            }

            // Si no está, guardamos el número actual y su índice
            map.put(nums[i], i);
        }

        System.out.println("No se encontró ninguna solución.");
    }

    public static void main(String[] args) {
        TwoSom c = new TwoSom();
        c.leerDatos();
        c.resuelve();
    }
}