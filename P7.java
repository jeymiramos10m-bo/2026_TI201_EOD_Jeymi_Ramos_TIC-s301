
/*
* FJMP-EDU
* ITESS TIC´s
* Estructura y Organizacion
* Tema 1 fundamentos de estructuras de datos
* P7 - Fibonacci
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P7 {

    FastReader reader = new FastReader();
    int N;

    static class FastReader {
        BufferedReader b;
        StringTokenizer s;

        public FastReader() {
            b = new BufferedReader(
                new InputStreamReader(System.in)
            );
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
    }

    public void leerDatos() {
        N = reader.nextInt();
    }

    // Metodo Fibonacci con recursion multiple
    public long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public void resuelve() {
        System.out.println("Resultado: " + fibonacci(N));
    }

    public static void main(String[] args) {
        P7 p = new P7();
        p.leerDatos();
        p.resuelve();
    }
}
