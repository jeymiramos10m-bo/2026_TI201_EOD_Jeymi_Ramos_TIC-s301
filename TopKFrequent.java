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
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TopKFrequent {
    FastReader reader = new FastReader();
    int N;       // Tamaño del arreglo
    int k;       // Cantidad de elementos más frecuentes a buscar
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
        k = reader.nextInt(); // Leemos N y luego k
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = reader.nextInt();
        }
    }

    public void resuelve() {
        //Contar la frecuencia de cada número con un HashMap
        Map<Integer, Integer> frecuenciaMap = new HashMap<>();
        for (int num : nums) {
            frecuenciaMap.put(num, frecuenciaMap.getOrDefault(num, 0) + 1);
        }

        //Usar un Min-Heap para mantener los k elementos más frecuentes
        // Ordenamos la cola de menor a mayor frecuencia para sacar fácilmente los menos frecuentes
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (n1, n2) -> frecuenciaMap.get(n1) - frecuenciaMap.get(n2)
        );

        for (int num : frecuenciaMap.keySet()) {
            minHeap.add(num);
            // Si el heap excede el tamaño k, removemos el elemento con menor frecuencia
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Paso 3: Extraer los elementos del Heap e imprimirlos
        System.out.println("Los " + k + " elementos más frecuentes son:");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TopKFrequent c = new TopKFrequent();
        c.leerDatos();
        c.resuelve();
    }
}