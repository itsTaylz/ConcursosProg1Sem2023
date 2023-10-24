import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class ProblemB {

    public static class Graph {
        private int[][] matrix;

        public Graph(int nNodes) {
            this.matrix = new int[nNodes][nNodes];
        }

        public void add(int start, int end) {
            this.matrix[start][end] = 1;
        }

        public List<Integer> succ(int n) {
            List<Integer> succ = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                if (this.matrix[n][i] == 1)
                    succ.add(i);
            }
            return succ;
        }

        public List<List<Integer>> findPaths(int start, int end) {
            List<List<Integer>> result = new ArrayList<>();
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(new Node(null, start));
            Set<Integer> explored = new HashSet<>();
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.num == end) {
                    result.add(node.path());
                } else {
                    for (int succ : succ(node.num)) {
                        queue.add(new Node(node, succ));
                    }
                }
            }
            return result;
        }
    }

    private static class Node {
        int num;
        Node parent;

        public Node(Node parent, int num) {
            this.parent = parent;
            this.num = num;
        }

        public List<Integer> path() {
            Deque<Integer> stack = new ArrayDeque<>();
            Node node = this;
            while (node != null) {
                stack.addFirst(node.num);
                node = node.parent;
            }
            return new ArrayList<>(stack);
        }
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int r = sc.nextInt();
        // int l = sc.nextInt();
        // Graph graph = new Graph(r);
        // Map<Integer, Integer> populations = new HashMap<>();
        // Map<Integer, Integer> capacities = new HashMap<>();
        // for (int i = 0; i < r; i++) {
        //     int pop = sc.nextInt();
        //     int capacity = sc.nextInt();
        //     populations.put(i, pop);
        //     capacities.put(i, capacity);
        // }
        // for (int i = 0; i < l; i++) {
        //     int n = sc.nextInt() - 1;
        //     int a = sc.nextInt() - 1;
        //     graph.add(n, a);
        // }
        Graph graph = new Graph(10);
        graph.add(0, 1);
        graph.add(1, 4);
        graph.add(0, 3);
        graph.add(0, 2);
        graph.add(2, 3);
        graph.add(3, 4);
        // int safe = sc.nextInt() - 1;
        System.out.println(graph.findPaths(0, 4));
    }

}