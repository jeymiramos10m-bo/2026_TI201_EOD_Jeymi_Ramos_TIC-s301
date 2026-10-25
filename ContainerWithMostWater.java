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

public class ContainerWithMostWater {

    int numero;
    int[] height;

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
        height = new int[numero];

        for (int i = 0; i < numero; i++) {
            height[i] = reader.nextInt();
        }
    }

    // Encontrar la cantidad maxima de agua
    public void resuelve() {

        int izquierda = 0;
        int derecha = numero - 1;

        long aguaMaxima = 0;

        while (izquierda < derecha) {

            // Calcular el ancho del recipiente
            int ancho = derecha - izquierda;

            // La altura depende de la linea mas baja
            int altura = Math.min(
                height[izquierda],
                height[derecha]
            );

            // Calcular el area del agua
            long agua = (long) ancho * altura;

            // Actualizar el maximo
            if (agua > aguaMaxima) {
                aguaMaxima = agua;
            }

            // Mover el apuntador de la linea mas baja
            if (height[izquierda] < height[derecha]) {
                izquierda++;
            } else {
                derecha--;
            }
        }

        // Mostrar el resultado
        System.out.println(aguaMaxima);
    }

    public static void main(String[] args) {

        ContainerWithMostWater id =
                new ContainerWithMostWater();

        id.leerDatos();
        id.resuelve();
    }
}
