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
import java.util.StringTokenizer;

public class TwoSumII {
    FastReader reader = new FastReader();
    int N;         // Tamaño del arreglo
    int target;    // Número objetivo
    int numbers[]; // Arreglo ordenado

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
        target = reader.nextInt(); // Leemos N y luego el target
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = reader.nextInt();
        }
    }

    public void resuelve() {
        int izquierda = 0;
        int derecha = N - 1;

        while (izquierda < derecha) {
            int suma = numbers[izquierda] + numbers[derecha];

            if (suma == target) {
                // El problema pide índices basados en 1 (1-indexed)
                System.out.println("[" + (izquierda + 1) + ", " + (derecha + 1) + "]");
                return;
            } else if (suma < target) {
                // Si la suma es menor, necesitamos un número mayor -> movemos la izquierda
                izquierda++;
            } else {
                // Si la suma es mayor, necesitamos un número menor -> movemos la derecha
                derecha--;
            }
        }

        System.out.println("No se encontró solución.");
    }

    public static void main(String[] args) {
        TwoSumII c = new TwoSumII();
        c.leerDatos();
        c.resuelve();
    }
}
