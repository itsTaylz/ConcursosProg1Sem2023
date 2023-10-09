import java.io.File;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(new File("input.txt"));
        int numberOfCases = reader.nextInt();
        for (int i = 0; i < numberOfCases; i++) {
            int numberOfComputers = reader.nextInt();
            reader.nextLine();
            Graph graph = new Graph(numberOfComputers, false);
            String line;
            int successful = 0;
            int unsuccesful = 0;
            do {
                line = reader.nextLine();
                if (!line.isEmpty()) {
                    String[] split = line.split(" ");
                    char op = split[0].charAt(0);
                    int c1 = Integer.parseInt(split[1]);
                    int c2 = Integer.parseInt(split[2]);
                    if (op == 'c') {
                        graph.add(c1 - 1, c2 - 1);
                    } else if (op == 'q') {
                        if (graph.isConnected(c1 - 1, c2 - 1))
                            successful++;
                        else
                            unsuccesful++;
                    }
                }
            } while (!line.isEmpty() && reader.hasNextLine());
            System.out.println(successful + "," + unsuccesful + "\n");
        }    
    }
}
