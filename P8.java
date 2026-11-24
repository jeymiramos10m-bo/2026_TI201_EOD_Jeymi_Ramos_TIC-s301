
/*
* FJMP-EDU
* ITESS TIC´s
* Estructura y Organizacion
* Tema 1 fundamentos de estructuras de datos
* P8 - Torres de Hanoi
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class P8 {

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

    // Metodo recursivo de Torres de Hanoi
    public void towerOfHanoi(
        int n, char from_rod,
        char to_rod, char aux_rod) {

        if (n == 0) {
            return;
        }

        // Mover n-1 discos de origen a auxiliar
        towerOfHanoi(
            n - 1, from_rod, aux_rod, to_rod
        );

        // Mover el disco mas grande al destino
        System.out.println(
            "Mover disco de " + from_rod + " a " + to_rod
        );

        // Mover n-1 discos de auxiliar a destino
        towerOfHanoi(
            n - 1, aux_rod, to_rod, from_rod
        );
    }

    public void resuelve() {

        if (N < 0) {
            System.out.println("Numero invalido");
            return;
        }

        System.out.println("Movimientos de Torres de Hanoi:");

        towerOfHanoi(N, 'A', 'C', 'B');

        BigInteger total = BigInteger.ONE
            .shiftLeft(N)
            .subtract(BigInteger.ONE);

        System.out.println("Total de movimientos: " + total);
    }

    public static void main(String[] args) {
        P8 p = new P8();
        p.leerDatos();
        p.resuelve();
    }
}
