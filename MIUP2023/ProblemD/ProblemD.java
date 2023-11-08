package ProblemD;

import java.util.Scanner;

public class ProblemD {
    
    // contar entre [a, b] = contar [0, b] - [0, a - 1]
    // b = 1100001
    // x = 1xxxxxx ou 0xxxxxx
    // contar(111111, 0, 0) para x = 1 e contar(10001, 1, 0) para x = 0 (em que 1 e o numero de 1s ja vistos)
    static int moreOnesThanZeros(int x) {

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(moreOnesThanZeros(b) - moreOnesThanZeros(a - 1));
        }
        sc.close();
        
    }
    
}
