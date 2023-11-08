import java.util.Scanner;

public class ProblemA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int i = 0; i < tests; i++) {
            int dim = sc.nextInt();
            sc.nextLine();
            String line = sc.nextLine();
            int amount = 0;
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'F') {
                    amount++;
                    j += dim - 1;
                }
            }
            System.out.println(amount);
        }
    }
}