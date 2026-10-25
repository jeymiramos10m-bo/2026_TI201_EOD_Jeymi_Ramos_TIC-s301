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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class IsSubSequence {
    FastReader reader = new FastReader();
    int numero;
    String palabra;

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
        numero=reader.nextInt();
        palabra=reader.next();


    }

    public void resuelve() {
        for(int i=0; i<numero; i++){
            String palabra2=reader.next();

            if(palabra2.length()== palabra.length()){
                System.out.println(palabra2 + "sigue la secuencia");
                        } else{
                            System.out.println(palabra2 + "No sigue la secuencia");
                                    }
        }
        
    }

    public static void main(String[] args) {
        IsSubSequence c = new IsSubSequence();
        c.leerDatos();
        c.resuelve();
    }
}