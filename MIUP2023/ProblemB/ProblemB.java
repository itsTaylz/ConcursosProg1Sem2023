import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ProblemB {

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

    static class Edge {
        int dest, cost;

        public Edge(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    static class Graph {

        int Q;
        List<List<Edge>> adjacencies; // usar hashmap

        public Graph(int n) {
            this.Q = n;
            this.adjacencies = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                this.adjacencies.add(new ArrayList<>());
            }
        }

        public void addEdge(int src, int dst, int cost) {
            this.adjacencies.get(src).add(new Edge(dst, cost));
        }

        // TLE
        public int distance(int src, int dest) {
            PriorityQueue<Edge> queue = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.cost, e2.cost));
            int[] totals = new int[Q];
            Arrays.fill(totals, Integer.MAX_VALUE);
            totals[src] = 0;
            queue.add(new Edge(src, 0));
            while (!queue.isEmpty()) {
                Edge edge = queue.poll();
                int cost = totals[edge.dest];
                if (edge.dest == dest) {
                    return cost;
                }
                for (Edge e : adjacencies.get(edge.dest)) {
                    int child = e.cost;
                    int childCost = cost + e.cost;
                    if (totals[child] > childCost && totals[dest] > childCost) {
                        totals[child] = childCost;
                        queue.add(new Edge(child, childCost));
                    }
                }
            }
            return -1;
        }

        // Other
        // public int dijsktra2(int src, int dst) {
            
        // }
    }


    public static void main(String[] args) throws IOException {
        Reader reader = new Reader(System.in);
        int Q = reader.nextInt();
        int S = reader.nextInt();
        int T = reader.nextInt();
        Graph graph = new Graph(Q);
        for (int i = 0; i < S; i++) {
            int src = reader.nextInt();
            int dst = reader.nextInt();
            int cost = reader.nextInt();
            graph.addEdge(src, dst, 0);
            graph.addEdge(dst, src, cost);
        }
        for (int i = 0; i < T; i++) {
            int src = reader.nextInt();
            int dst = reader.nextInt();
            System.out.println(graph.distance(src, dst));
        }

    }
}