import java.util.Scanner;

public class ProblemE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int i = 0; i < tests; i++) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            int[] xs = new int[w];
            int[] ys = new int[h];
            for (int j = 0; j < w; j++) {
                xs[j] = sc.nextInt();
            }
            for (int j = 0; j < h; j++) {
                ys[j] = sc.nextInt();
            }
            int x1 = xs[0];
            int y1 = ys[0];
            int xn = xs[xs.length - 1];
            int yn = ys[ys.length - 1];

            int xbest = Integer.MAX_VALUE;
            int diffbest = Integer.MAX_VALUE;
            for (int j = 0; j < xs.length; j++) {
                int x = xs[j];
                int dist1 = Math.abs(x - x1);
                int dist2 = Math.abs(x - xn);
                int diff = Math.abs(dist1 - dist2);
                if (diff < diffbest) {
                    xbest = x;
                    diffbest = diff;
                }
            }
            int ybest = Integer.MAX_VALUE;
            diffbest = Integer.MAX_VALUE;
            for (int j = 0; j < ys.length; j++) {
                int y = ys[j];
                int dist1 = Math.abs(y - y1);
                int dist2 = Math.abs(y - yn);
                int diff = Math.abs(dist1 - dist2);
                if (diff < diffbest) {
                    ybest = y;
                    diffbest = diff;
                }
            }
            System.out.println(xbest + " " + ybest);
        }
    }
}