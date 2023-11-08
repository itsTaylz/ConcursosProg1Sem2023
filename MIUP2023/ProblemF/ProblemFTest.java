import java.io.PrintWriter;
import java.util.Random;

public class ProblemFTest {

    static final int N = 500_000;
    static final int M = 100_000;

    public static void main(String[] args) throws Exception {
        PrintWriter writer = new PrintWriter("inputtest.txt");
        writer.println(N);
        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            int num = rand.nextInt(1, 100_001);
            writer.print(num);
            if (i != N - 1)
                writer.print(" ");
        }
        writer.println();
        writer.println(M);
        for (int i = 0; i < M; i++) {
            int num = rand.nextInt(1, 100_001);
            writer.print(num);
            if (i != M - 1)
                writer.print(" ");
        }
        writer.close();
    }
    
}
