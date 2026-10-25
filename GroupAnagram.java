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

public class GroupAnagram {
    FastReader reader = new FastReader();
    int N;             // Cantidad de palabras
    String palabras[]; // Arreglo de palabras

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
        palabras = new String[N];
        for (int i = 0; i < N; i++) {
            palabras[i] = reader.next();
        }
    }

    public void resuelve() {
        if (N == 0) return;

        Map<String, List<String>> map = new HashMap<>();

        for (String palabra : palabras) {
            // Convertimos la palabra a un arreglo de caracteres, lo ordenamos y lo volvemos String
            char[] chars = palabra.toCharArray();
            Arrays.sort(chars);
            String claveOrdenada = new String(chars);

            // Si la clave ordenada no existe en el mapa, creamos una nueva lista
            if (!map.containsKey(claveOrdenada)) {
                map.put(claveOrdenada, new ArrayList<>());
            }

            // Agregamos la palabra original a su grupo correspondiente
            map.get(claveOrdenada).add(palabra);
        }

        // Imprimimos los grupos de anagramas encontrados
        System.out.println("Grupos de anagramas encontrados:");
        for (List<String> grupo : map.values()) {
            System.out.println(grupo);
        }
    }

    public static void main(String[] args) {
        GroupAnagram c = new GroupAnagram();
        c.leerDatos();
        c.resuelve();
    }
}