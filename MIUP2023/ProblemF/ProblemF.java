import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ProblemF {

    static class Reader {

        private final BufferedReader reader;
        private StringTokenizer tokenizer;
        
        public Reader(InputStream inStream) {
            this.reader = new BufferedReader(new InputStreamReader(inStream));
            this.tokenizer = new StringTokenizer("");
        }

        public String next() throws IOException {
            while (!this.tokenizer.hasMoreTokens()) {
                this.tokenizer = new StringTokenizer(this.reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }

    public static void main(String[] args) throws IOException {
        // Reader reader = new Reader(System.in);
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = reader.nextInt();
            if (!map.containsKey(num))
                map.put(num, 1);
            else {
                int count = map.get(num);
                map.put(num, count + 1);
            }
        }
        int m = reader.nextInt();
        int sum = 0;
        for (int i = 0; i < m; i++) {
            int num = reader.nextInt();
            if (map.containsKey(num)) {
                sum += map.get(num);
            }
        }
        System.out.println(sum);
    }
}