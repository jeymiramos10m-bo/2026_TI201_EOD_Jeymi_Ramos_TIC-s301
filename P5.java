import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5 {
    int n;
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
    }

    /** Returns the nth Fibonacci number (inefficiently). */
    public static long fibonacciBad(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacciBad(n - 2) + fibonacciBad(n - 1);
        }
    }

    /** Returns array containing the pair of Fibonacci numbers, F(n) and F(n-1). */
    public static long[] fibonacciGood(int n) {
        if (n <= 1) {
            long[] answer = {n, 0};
            return answer;
        } else {
            long[] temp = fibonacciGood(n - 1); // returns {F_{n-1}, F_{n-2}}
            long[] answer = {temp[0] + temp[1], temp[0]}; // we want {F_n, F_{n-1}}
            return answer;
        }
    }

    public void leerDatos() {
        n = reader.nextInt();
    }

    public void resuelve() {
        long badResult = fibonacciBad(n);
        long[] goodResult = fibonacciGood(n);
        System.out.println("fibonacciBad(" + n + ") = " + badResult);
        System.out.println("fibonacciGood(" + n + ") = [" + goodResult[0] + ", " + goodResult[1] + "]");
    }

    public static void main(String[] args) {
        P5 id = new P5();
        id.leerDatos();
        id.resuelve();
    }
}
