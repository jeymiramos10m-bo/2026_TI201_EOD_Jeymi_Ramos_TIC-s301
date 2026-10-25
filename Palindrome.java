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

public class Palindrome {
    FastReader reader = new FastReader();
    String s; // Cadena de texto a evaluar

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

        // Método para leer líneas completas con espacios (vital para este problema)
        String nextLine() {
            String str = "";
            try {
                if (st != null && st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = b.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public void leerDatos() {
        s = reader.nextLine();
    }

    public void resuelve() {
        if (s == null) {
            System.out.println("false");
            return;
        }

        int izquierda = 0;
        int derecha = s.length() - 1;
        boolean esPalindromo = true;

        while (izquierda < derecha) {
            char cIzq = s.charAt(izquierda);
            char cDer = s.charAt(derecha);

            // Si el carácter de la izquierda no es letra o número, avanzamos
            if (!Character.isLetterOrDigit(cIzq)) {
                izquierda++;
            } 
            // Si el carácter de la derecha no es letra o número, retrocedemos
            else if (!Character.isLetterOrDigit(cDer)) {
                derecha--;
            } 
            // Ambos son válidos, los comparamos en minúsculas
            else {
                if (Character.toLowerCase(cIzq) != Character.toLowerCase(cDer)) {
                    esPalindromo = false;
                    break;
                }
                izquierda++;
                derecha--;
            }
        }

        if (esPalindromo) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void main(String[] args) {
        Palindrome c = new Palindrome();
        c.leerDatos();
        c.resuelve();
    }
}
