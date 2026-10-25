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

public class LongestRepeatingCharacterReplacement {

    String s;
    int k;

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
        s = reader.next();
        k = reader.nextInt();
    }

    // Encontrar la subcadena mas larga
    public void resuelve() {

        int[] frecuencia = new int[26];

        int izquierda = 0;
        int frecuenciaMaxima = 0;
        int resultado = 0;

        for (int derecha = 0; derecha < s.length(); derecha++) {

            // Contar la letra actual
            int letra = s.charAt(derecha) - 'A';
            frecuencia[letra]++;

            // Guardar la frecuencia mas alta
            frecuenciaMaxima = Math.max(
                frecuenciaMaxima, frecuencia[letra]);

            // Verificar si necesitamos cambiar demasiadas letras
            while ((derecha - izquierda + 1)
                    - frecuenciaMaxima > k) {

                int letraIzquierda = s.charAt(izquierda) - 'A';
                frecuencia[letraIzquierda]--;
                izquierda++;
            }

            // Guardar la longitud maxima
            resultado = Math.max(
                resultado, derecha - izquierda + 1);
        }

        System.out.println(resultado);
    }

    public static void main(String[] args) {

        LongestRepeatingCharacterReplacement id =
                new LongestRepeatingCharacterReplacement();

        id.leerDatos();
        id.resuelve();
    }
}
