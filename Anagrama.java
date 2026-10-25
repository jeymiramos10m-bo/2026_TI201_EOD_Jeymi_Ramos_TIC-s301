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

public class Anagrama {
    FastReader reader = new FastReader();
    String s; // Primera cadena
    String t; // Segunda cadena

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
    }

    public void leerDatos() {
        s = reader.next();
        t = reader.next();
    }

    public void resuelve() {
        // Si las longitudes son distintas, nunca podrán ser anagramas
        if (s.length() != t.length()) {
            System.out.println("false (No son anagramas)");
            return;
        }

        // Arreglo para contar la frecuencia de cada letra del alfabeto inglés
        int[] contador = new int[26];

        for (int i = 0; i < s.length(); i++) {
            contador[s.charAt(i) - 'a']++; // Suma 1 por cada letra en 's'
            contador[t.charAt(i) - 'a']--; // Resta 1 por cada letra en 't'
        }

        // Si todas las posiciones terminan en 0, es un anagrama
        for (int c : contador) {
            if (c != 0) {
                System.out.println("false (No son anagramas)");
                return;
            }
        }

        System.out.println("true (Son anagramas)");
    }

    public static void main(String[] args) {
        Anagrama c = new Anagrama();
        c.leerDatos();
        c.resuelve();
    }
}