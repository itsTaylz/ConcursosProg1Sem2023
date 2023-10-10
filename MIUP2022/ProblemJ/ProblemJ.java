import java.util.Scanner;

public class ProblemJ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numDays = sc.nextInt();
        int[] temps = new int[numDays];
        for (int i = 0; i < numDays; i++) {
            temps[i] = sc.nextInt();
        }
        int numOps = sc.nextInt();
        for (int i = 0; i < numOps; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                int temp = sc.nextInt();
                int count = 0;
                for (int j = a; j <= b; j++) {
                    if (temps[j] > temp)
                        count++;
                }
                System.out.println(count);
            } else {
                int d = sc.nextInt();
                int temp = sc.nextInt();
                temps[d - 1] = temp;
            }
        }
    }
}