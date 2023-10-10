import java.util.Arrays;
import java.util.Scanner;

public class ProblemI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int w = sc.nextInt();
        int obstacles = sc.nextInt();
        char[][] field = new char[w][l];
        for (int i = 0; i < obstacles; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    field[y][x] = 'o';
                }
            }
        }

        int count = 0;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < l; j++) {
                if (field[i][j] != 'o') {
                    count++;
                } 
            }
        }
        System.out.println(count);
    }
}