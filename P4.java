import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4 {
    int[] data;
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

    /** Returns the sum of subarray data[low] through data[high] inclusive. */
    public static int binarySum(int[] data, int low, int high) {
        if (low > high) { // zero elements in subarray
            return 0;
        } else if (low == high) { // one element in subarray
            return data[low];
        } else {
            int mid = (low + high) / 2;
            return binarySum(data, low, mid) + binarySum(data, mid + 1, high);
        }
    }

    public void leerDatos() {
        int tam = reader.nextInt();
        data = new int[tam];
        for (int i = 0; i < tam; i++) {
            data[i] = reader.nextInt();
        }
    }

    public void resuelve() {
        int resultado = binarySum(data, 0, data.length - 1);
        System.out.println(resultado);
    }

    public static void main(String[] args) {
        P4 id = new P4();
        id.leerDatos();
        id.resuelve();
    }
}
