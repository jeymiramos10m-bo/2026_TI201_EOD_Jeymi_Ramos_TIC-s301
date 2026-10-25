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

public class ProductExceptSelf {
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
        int[] resultado = new int[N];

        // Calcular los productos de los elementos a la izquierda (Prefix)
        resultado[0] = 1;
        for (int i = 1; i < N; i++) {
            resultado[i] = resultado[i - 1] * nums[i - 1];
        }

        // Multiplicar por los productos de los elementos a la derecha (Postfix)
        int derecho = 1;
        for (int i = N - 1; i >= 0; i--) {
            resultado[i] = resultado[i] * derecho;
            derecho *= nums[i];
        }

        // Imprimir el arreglo resultante
        System.out.println("El producto del arreglo excepto sí mismo es:");
        for (int i = 0; i < N; i++) {
            System.out.print(resultado[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ProductExceptSelf c = new ProductExceptSelf();
        c.leerDatos();
        c.resuelve();
    }
}