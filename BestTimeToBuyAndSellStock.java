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

public class BestTimeToBuyAndSellStock {

    int numero;
    int[] prices;

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
        prices = new int[numero];

        for (int i = 0; i < numero; i++) {
            prices[i] = reader.nextInt();
        }
    }

    // Calcular la ganancia maxima
    public void resuelve() {

        int precioMinimo = prices[0];
        int gananciaMaxima = 0;

        for (int i = 1; i < numero; i++) {

            // Calcular la ganancia si vendemos hoy
            int ganancia = prices[i] - precioMinimo;

            // Guardar la mayor ganancia
            if (ganancia > gananciaMaxima) {
                gananciaMaxima = ganancia;
            }

            // Actualizar el precio minimo de compra
            if (prices[i] < precioMinimo) {
                precioMinimo = prices[i];
            }
        }

        // Mostrar la ganancia maxima
        System.out.println(gananciaMaxima);
    }

    public static void main(String[] args) {

        BestTimeToBuyAndSellStock id =
                new BestTimeToBuyAndSellStock();

        id.leerDatos();
        id.resuelve();
    }
}
