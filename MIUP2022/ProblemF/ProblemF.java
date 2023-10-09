import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class ProblemF {

    private static final char[] ACTIONS = {'u', 'd', 'e', 'w'};

    private static class Node {
        public int x, y;
        public int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public boolean equals(Object other) {
            return other instanceof Node n && n.x == this.x && n.y == this.y;
        }

        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }
    }

    public static List<Character> actions(Node current, String[] map) {
        List<Character> actions = new ArrayList<>();
        for (char a : ACTIONS) {
            if (movePos(current, a, map) != null) 
                actions.add(a);
        }
        return actions;
    }

    public static Node movePos(Node current, char dir, String[] map) {
        int xMove = dir == 'e' ? 1 : dir == 'w' ? -1 : 0;
        int yMove = dir == 'd' ? 1 : dir == 'u' ? -1 : 0;
        int x = current.x;
        int y = current.y;
        while (x >= 0 && y >= 0 && x < map[0].length() && y < map.length) {
            if (map[y].charAt(x) == 'H')
                return new Node(x, y, current.cost + 1);
            if (map[y].charAt(x) == 'O')
                return new Node(x - xMove, y - yMove, current.cost + 1);
            x += xMove;
            y += yMove;
        }
        return null;
    }

    public static Node[] expandNode(Node node, String[] map) {
        List<Character> actions = actions(node, map);
        Node[] result = new Node[actions.size()];
        for (int i = 0; i < actions.size(); i++) {
            result[i] = movePos(node, actions.get(i), map);
        }
        return result;
    }

    public static int search(Node root, String[] map) {
        Set<Node> explored = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            // System.out.println(actions(root, map));
            explored.add(node);
            Node[] childs = expandNode(node, map);
            for (Node child : childs) {
                if (map[child.y].charAt(child.x) == 'H')
                    return child.cost;
                if (!explored.contains(child))
                    queue.add(child);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();
        int numTests = sc.nextInt();
        sc.nextLine();
        String[] map = new String[rows];
        for (int i = 0; i < rows; i++) {
            map[i] = sc.nextLine();
        }

        for (int i = 0; i < numTests; i++) {
            int y = sc.nextInt();
            int x = sc.nextInt();
            Node root = new Node(x - 1, y - 1, 0);
            int sol = search(root, map);
            if (sol == -1)
                System.out.println("Stuck");
            else
                System.out.println(sol);
        }

    }
}