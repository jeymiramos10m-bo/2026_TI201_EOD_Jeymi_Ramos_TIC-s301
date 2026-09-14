package pkg2026_agosto_diciembre_eod_jeymi_jimena_ramos_martínez;
/*
*   FJMP-EDU @ 2026
*   Plantilla de configuración ICPC java
*   frajavimopu@gmail.com
*    
*   Problema 7.18 - Juego de Craps (Deitel)
*   Simula 1,000,000 de juegos de Craps y calcula estadísticas detalladas.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class CrapsApp {
    long totalJuegos = 1_000_000L;
    
    // Enumeración para el estado del juego
    enum Estado { CONTINUAR, GANO, PERDIO }

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
    try {
        // Verifica si la consola realmente tiene datos listos para ser leídos
        if (System.in.available() > 0) {
            String linea = reader.nextLine();
            if (linea != null && !linea.trim().isEmpty()) {
                totalJuegos = Long.parseLong(linea.trim());
            }
        }
    } catch (Exception e) {
        // Si no hay entrada o ocurre un error, mantiene el valor por defecto
    }
}

    public void resuelve() {
        Random random = new Random();

        // Arreglos de contadores para tiros del 1 al 21 (índice 21 representa 21 o más)
        int[] victoriasPorTiro = new int[22];
        int[] derrotasPorTiro = new int[22];

        long totalVictorias = 0;
        long totalTirosJuegos = 0;

        for (long i = 0; i < totalJuegos; i++) {
            int numeroTiro = 1;
            int miPunto = 0;
            Estado estadoJuego;

            // Primer tiro
            int sumaDados = tirarDados(random);

            switch (sumaDados) {
                case 7:
                case 11:
                    estadoJuego = Estado.GANO;
                    break;
                case 2:
                case 3:
                case 12:
                    estadoJuego = Estado.PERDIO;
                    break;
                default:
                    estadoJuego = Estado.CONTINUAR;
                    miPunto = sumaDados;
                    break;
            }

            // Tiros posteriores si el juego continúa
            while (estadoJuego == Estado.CONTINUAR) {
                numeroTiro++;
                sumaDados = tirarDados(random);

                if (sumaDados == miPunto) {
                    estadoJuego = Estado.GANO;
                } else if (sumaDados == 7) {
                    estadoJuego = Estado.PERDIO;
                }
            }

            // Acumular la duración global
            totalTirosJuegos += numeroTiro;

            // Mapear al rango 1..21
            int indiceTiro = Math.min(numeroTiro, 21);

            if (estadoJuego == Estado.GANO) {
                victoriasPorTiro[indiceTiro]++;
                totalVictorias++;
            } else {
                derrotasPorTiro[indiceTiro]++;
            }
        }

        // IMPRESIÓN DE RESULTADOS Y RESPUESTAS
        System.out.println("=== SIMULACION DEL JUEGO DE CRAPS ===");
        System.out.println("Total de juegos simulados: " + totalJuegos + "\n");

        System.out.println("a) y b) Juegos ganados y perdidos por numero de tiro:");
        System.out.printf("%-10s | %-12s | %-12s\n", "Tiro #", "Ganados", "Perdidos");
        System.out.println("----------------------------------------");
        
        for (int i = 1; i <= 20; i++) {
            System.out.printf("Tiro %-5d | %-12d | %-12d\n", i, victoriasPorTiro[i], derrotasPorTiro[i]);
        }
        System.out.printf("Despues 20  | %-12d | %-12d\n", victoriasPorTiro[21], derrotasPorTiro[21]);
        System.out.println("----------------------------------------\n");

        double probabilidadGanar = (totalVictorias / (double) totalJuegos) * 100;
        double duracionPromedio = totalTirosJuegos / (double) totalJuegos;

        System.out.printf("c) Probabilidad de ganar en Craps: %.2f%%\n", probabilidadGanar);
        System.out.println("   Significado: Las probabilidades de ganar son aproximadamente del 49.3%, lo cual");
        System.out.println("   lo convierte en uno de los juegos mas 'justos' del casino porque la ventaja");
        System.out.println("   de la casa es muy pequeña (alrededor del 1.41%).\n");

        System.out.printf("d) Duracion promedio de un juego: %.2f tiros\n\n", duracionPromedio);

        System.out.println("e) ¿Las probabilidades de ganar mejoran con la duracion del juego?");
        System.out.println("   No. A medida que un juego se alarga, la probabilidad de ganar disminuye.");
        System.out.println("   Esto ocurre porque para ganar debes repetir tu 'punto' antes de que salga un 7,");
        System.out.println("   y la probabilidad de sacar un 7 (1/6) es mas alta que la de sacar cualquier punto.");
    }

    private int tirarDados(Random random) {
        int dado1 = 1 + random.nextInt(6);
        int dado2 = 1 + random.nextInt(6);
        return dado1 + dado2;
    }

    public static void main(String[] args) {
        CrapsApp id = new CrapsApp();
        id.leerDatos();
        id.resuelve();
    }   
}