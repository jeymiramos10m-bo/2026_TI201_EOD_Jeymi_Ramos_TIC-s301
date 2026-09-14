package pkg2026_agosto_diciembre_eod_jeymi_jimena_ramos_martínez;
/*
*   FJMP-EDU @ 2026
*   Plantilla de configuración ICPC java
*   frajavimopu@gmail.com
*    
*   Ejercicios 7.10, 7.11 y 7.12 (Deitel)
*   
*   Formato de entrada en Dato1.txt (o consola):
*     - Primera línea: N (número de vendedores para 7.10)
*     - Siguientes N líneas: ventas brutas de cada vendedor.
*     - Siguientes 5 líneas (o enteros): 5 números entre 10 y 100 para 7.12.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class VentasApp {
    // Lectura de datos para el 7.10
    int nVendedores;
    double[] ventas;

    // Lectura de datos para el 7.12
    int[] numeros712 = new int[5];

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
        // Datos para 7.10
        nVendedores = reader.nextInt();
        ventas = new double[nVendedores];
        for (int i = 0; i < nVendedores; i++) {
            ventas[i] = reader.nextDouble();
        }

        // Datos para 7.12
        for (int i = 0; i < 5; i++) {
            numeros712[i] = reader.nextInt();
        }
    }

    public void resuelve() {
       
        // EJERCICIO 7.10: Comisión por ventas
        
        System.out.println("=== EJERCICIO 7.10 ===");
        int[] rangos = new int[9];

        for (int i = 0; i < nVendedores; i++) {
            int salario = 200 + (int)(0.09 * ventas[i]);
            int indice = (salario / 100) - 2;

            if (indice >= 8) {
                indice = 8;
            }
            if (indice < 0) {
                indice = 0;
            }

            rangos[indice]++;
        }

        // Formato tabular
        System.out.println("Rango de Salario\t\tCantidad");
        System.out.println("----------------------------------------");
        String[] rangosTexto = {
            "a) $200-299", "b) $300-399", "c) $400-499",
            "d) $500-599", "e) $600-699", "f) $700-799",
            "g) $800-899", "h) $900-999", "i) $1,000 en adelante"
        };

        for (int i = 0; i < 9; i++) {
            System.out.printf("%-24s\t%d\n", rangosTexto[i], rangos[i]);
        }
        System.out.println();

        // EJERCICIO 7.11: Operaciones con arreglos
        
        System.out.println("=== EJERCICIO 7.11 ===");
        
        // a) Asignar cero a los 10 elementos del arreglo cuentas de tipo entero
        int[] cuentas = new int[10];
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = 0;
        }

        // b) Se Suma uno a cada uno de los 15 elementos del arreglo bono de tipo entero
        int[] bono = new int[15];
        for (int i = 0; i < bono.length; i++) {
            bono[i] += 1;
        }

        // c)se imprime las mejores 5 puntuaciones
        int[] mejoresPuntuaciones = {98, 95, 92, 88, 85};
        System.out.println("Mejores Puntuaciones:");
        for (int i = 0; i < mejoresPuntuaciones.length; i++) {
            System.out.println("Puntuación " + (i + 1) + ":\t" + mejoresPuntuaciones[i]);
        }
        System.out.println();
        
        //Eliminación de duplicados
        System.out.println("=== EJERCICIO 7.12 ===");
        int[] unicos = new int[5];
        int cantidadUnicos = 0;

        for (int i = 0; i < 5; i++) {
            int num = numeros712[i];
            
            // Validar rango [10, 100]
            if (num >= 10 && num <= 100) {
                boolean esDuplicado = false;

                // Verificar si ya fue ingresado
                for (int j = 0; j < cantidadUnicos; j++) {
                    if (unicos[j] == num) {
                        esDuplicado = true;
                        break;
                    }
                }

                // Si no es duplicado se agrega al arreglo e imprime
                if (!esDuplicado) {
                    unicos[cantidadUnicos] = num;
                    cantidadUnicos++;
                    System.out.println("Nuevo valor único guardado: " + num);
                } else {
                    System.out.println("El número " + num + " es duplicado (ignorado).");
                }

                // Mostrar el conjunto acumulado de valores únicos
                System.out.print("Valores únicos acumulados: ");
                for (int k = 0; k < cantidadUnicos; k++) {
                    System.out.print(unicos[k] + " ");
                }
                System.out.println("\n");
            } else {
                System.out.println("El número " + num + " está fuera del rango [10, 100].\n");
            }
        }
    }

    public static void main(String[] args) {
        VentasApp id = new VentasApp();
        id.leerDatos();
        id.resuelve();
    }   
}