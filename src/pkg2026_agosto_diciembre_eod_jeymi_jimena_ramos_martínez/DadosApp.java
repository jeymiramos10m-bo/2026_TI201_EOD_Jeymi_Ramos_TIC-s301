package pkg2026_agosto_diciembre_eod_jeymi_jimena_ramos_martínez;
/*
*   FJMP-EDU @ 2026
*   Plantilla de configuración ICPC java
*   frajavimopu@gmail.com
*    
*   Problema 7.17 - Tiro de dados (Deitel)
*   Simula 36,000,000 de lanzamientos de 2 dados.
*   Registra las frecuencias de las sumas de 2 a 12 en un arreglo unidimensional.
*   Imprime los resultados en formato tabular.
*
*   Entrada opcional en Dato1.txt (o consola):
*     - Número de lanzamientos (si no se proporciona, usa 36,000,000 por defecto).
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class DadosApp {
    // Número total de lanzamientos
    long totalLanzamientos = 36_000_000L;
    
    FastReader reader = new FastReader();

    static class FastReader {
        BufferedReader b;
        StringTokenizer s; 

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (s == null || !s.hasMoreTokens()) {
                try {
                    String line = b.readLine();
                    if (line == null) return null;
                    s = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace(); 
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
            String str = "";
            try {
                if (s != null && s.hasMoreTokens()) {
                    str = s.nextToken("\n");
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
        // lee el numero de lanzamientos
        String token = reader.next();
        if (token != null) {
            try {
                totalLanzamientos = Long.parseLong(token);
            } catch (NumberFormatException e) {
                // Si no es un número válido, se mantiene el valor por defau
            }
        }
    }

    public void resuelve() {
        // Arreglo unidimensional para registrar las frecuencias de las sumas de 2 a 12 (tamaño 13)
        int[] frecuencias = new int[13];
        Random random = new Random();

        // Simulación de los 36,000,000 de tiros
        for (long i = 0; i < totalLanzamientos; i++) {
            int dado1 = 1 + random.nextInt(6); // Valor entre 1 y 6
            int dado2 = 1 + random.nextInt(6); // Valor entre 1 y 6
            int suma = dado1 + dado2;
            
            frecuencias[suma]++;
        }

        // Impresión en formato tabular
        System.out.println("=== SIMULACION DE TIRO DE DOS DADOS ===");
        System.out.println("Total de lanzamientos: " + totalLanzamientos + "\n");
        System.out.printf("%-6s | %-15s | %-12s\n", "Suma", "Frecuencia", "Porcentaje");
        System.out.println("----------------------------------------");

        for (int suma = 2; suma <= 12; suma++) {
            double porcentaje = (frecuencias[suma] / (double) totalLanzamientos) * 100;
            System.out.printf("%-6d | %-15d | %6.2f%%\n", suma, frecuencias[suma], porcentaje);
        }
    }

    public static void main(String[] args) {
        DadosApp id = new DadosApp();
        id.leerDatos();
        id.resuelve();
    }   
}