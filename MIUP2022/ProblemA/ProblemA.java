import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class ProblemA {

    private static class Applicant {
        public String name;
        public int followers, cv;

        public Applicant(String name, int follow, int cv) {
            this.name = name;
            this.followers = follow;
            this.cv = cv;
        }

        @Override
        public boolean equals(Object other) {
            return other instanceof Applicant app && app.name.equals(name);
        }
    }

    private static class Node {
        Applicant applicant;
        Node parent;

        public Node(Node parent, Applicant app) {
            this.parent = parent;
            this.applicant = app;
        }
    }

    public static int calcCV(Node node) {
        int cv = 0;
        while (node != null) {
            cv += node.applicant.cv;
            node = node.parent;
        }
        return cv;
    }

    public static int calcFollowers(Node node) {
        int f = 0;
        while (node != null) {
            f += node.applicant.followers;
            node = node.parent;
        }
        return f;
    }

    public static Set<Applicant> getApplicants(Node node) {
        Set<Applicant> apps = new HashSet<>();
        while (node != null) {
            apps.add(node.applicant);
            node = node.parent;
        }
        return apps;
    }

    public static Node depthSearch(Node root, List<Applicant> app, int maxFollowers) {
        Node sol = null;
        Deque<Node> nodes = new ArrayDeque<>();
        nodes.add(root);
        System.out.println("STARTING FROM " + root.applicant.name);
        while (!nodes.isEmpty()) {
            Node node = nodes.pop();
            // System.out.println("POP " + node.applicant.name);
            // System.out.println(node);
            Set<Applicant> apps = getApplicants(node);
            int followers = calcFollowers(node);
            List<Node> childs = app.stream()
                .map(a -> new Node(node, a))
                .filter(n -> !apps.contains(n.applicant))
                .filter(n -> followers + n.applicant.followers <= maxFollowers)
                .toList();
            if (childs.isEmpty()) {
                if (sol == null)
                    sol = node;
                else if (calcCV(node) > calcCV(sol))
                    sol = node;
            } else {
                nodes.addAll(childs);
            }
        }
        return sol;
    }

    public static Node searchSol(List<Applicant> apps, int maxFollowers) {
        Node sol = null;
        for (Applicant a : apps) {
            Node res = depthSearch(new Node(null, a), apps, maxFollowers);
            if (sol == null)
                sol = res;
            if (calcCV(sol) < calcCV(res))
                sol = res;
        }
        return sol;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        List<Applicant> apps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int followers = sc.nextInt();
            int cv = sc.nextInt();
            Applicant app = new Applicant(name, followers, cv);
            apps.add(app);
            if (i != n - 1)
                sc.nextLine();
        }
        Node sol = searchSol(apps, capacity);
        Set<Applicant> res = getApplicants(sol);
        System.out.println(res.size() + " " + calcFollowers(sol) + " " + calcCV(sol));
        res.stream().forEach(a -> System.out.println(a.name));
    }
}