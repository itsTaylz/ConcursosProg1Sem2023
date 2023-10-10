import java.util.Scanner;

public class ProblemE {

    public static class Pos {
        int x;
        int y;
        
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object other) {
            return other instanceof Pos pos && pos.x == this.x && pos.y == this.y;
        }
    }

    public static int dist(Pos pos1, Pos pos2) {
        return Math.abs(pos1.x - pos2.x) + Math.abs(pos1.y - pos2.y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        for (int i = 0; i < tests; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] ns = new int[n];
            int[] ms = new int[m];
            for (int j = 0; j < n; j++) {
                ns[j] = sc.nextInt();
            }
            for (int j = 0; j < m; j++) {
                ms[j] = sc.nextInt();
            }
            Pos ana = new Pos(ns[0], ms[0]);
            Pos pedro = new Pos(ns[n - 1], ms[m - 1]);
            Pos[] allPos = new Pos[n * m];
            int index = 0;
            for (int nn : ns) {
                for (int mm : ms) {
                    allPos[index++] = new Pos(nn, mm);
                }
            }
            Pos minPos = ana;
            int dist = dist(ana, pedro);
            for (Pos pos : allPos) {
                int distPos = Math.abs(dist(pos, ana) - dist(pos, pedro));
                if (distPos < dist) {
                    dist = distPos;
                    minPos = pos;
                }
            }
            System.out.println(minPos.x + " " + minPos.y);
        }
    }
}