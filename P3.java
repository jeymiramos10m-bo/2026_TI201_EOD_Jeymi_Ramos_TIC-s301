import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3 {
    double x;
    int[] exponentes;
    FastReader reader = new FastReader();

    static class FastReader {
        BufferedReader b;
        StringTokenizer s;

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (s == null || !s.hasMoreElements()) {
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

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    /** BAD algorithm: trivial linear recursion O(n). */
    public static double powerBad(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * powerBad(x, n - 1);
        }
    }

    /** GOOD algorithm: repeated squaring O(log n). */
    public static double powerGood(double x, int n) {
        if (n == 0) {
            return 1;
        } else {
            double partial = powerGood(x, n / 2); // rely on truncated division of n
            double result = partial * partial;
            if (n % 2 == 1) { // if n odd, include extra factor of x
                result *= x;
            }
            return result;
        }
    }

    public void leerDatos() {
        x = reader.nextDouble();
        int cant = reader.nextInt();
        exponentes = new int[cant];
        for (int i = 0; i < cant; i++) {
            exponentes[i] = reader.nextInt();
        }
    }

    public void resuelve() {
        System.out.println("Estado inicial -> Base x: " + x + " | Cantidad de pruebas: " + exponentes.length);
        System.out.printf("%-8s %-18s %-18s %-22s%n", "N", "Tiempo bad (ms)", "Tiempo good (ms)", "Resultado final");

        for (int n : exponentes) {
            long inicioBad = System.nanoTime();
            double resBad = powerBad(x, n);
            long finBad = System.nanoTime();
            double tiempoBadMs = (finBad - inicioBad) / 1_000_000.0;

            long inicioGood = System.nanoTime();
            double resGood = powerGood(x, n);
            long finGood = System.nanoTime();
            double tiempoGoodMs = (finGood - inicioGood) / 1_000_000.0;

            System.out.printf("%-8d %-18.6f %-18.6f %-22.6f%n", n, tiempoBadMs, tiempoGoodMs, resGood);
            if (Math.abs(resBad - resGood) > 1e-9) {
                System.out.println("Advertencia: diferencia numerica entre BAD y GOOD para N=" + n);
            }
        }

        System.out.println("Estado final -> Ejecucion completada para todos los exponentes.");
    }

    public static void main(String[] args) {
        P3 id = new P3();
        id.leerDatos();
        id.resuelve();
    }
}
