import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ProblemK {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numAirlines = sc.nextInt();
        sc.nextLine();
        Set<String> airports = new HashSet<>(Arrays.asList("Lisboa", "Porto", "Faro", "Funchal", "Beja"));
        Set<String> airlines = new HashSet<>();
        for (int i = 0; i < numAirlines; i++) {
            airlines.add(sc.next());
        }
        int numFlights = sc.nextInt();
        Map<Integer, Integer> dayCounter = new HashMap<>();
        for (int i = 0; i < numFlights; i++) {
            String airline = sc.next();
            if (!airlines.contains(airline)) {
                sc.nextLine();
                continue;
            }
            String airport = sc.next();
            int startDay = sc.nextInt();
            sc.next();
            String arrAirport = sc.next();
            int arrivalDay = sc.nextInt();
            sc.nextLine();
            if (airports.contains(airport)) {
                dayCounter.putIfAbsent(startDay, 0);
                int count = dayCounter.get(startDay);
                dayCounter.put(startDay, count + 1);
            }
            if (airports.contains(arrAirport)) {
                dayCounter.putIfAbsent(arrivalDay, 0);
                int count = dayCounter.get(arrivalDay);
                dayCounter.put(arrivalDay, count + 1);
            }
        }

        if (dayCounter.isEmpty()) {
            System.out.println(1);
            System.out.println(0);
        } else {
            int maxDay = 0;
            int maxFlights = 0;
            for (Integer day : dayCounter.keySet()) {
                int flights = dayCounter.get(day);
                if (flights > maxFlights) {
                    maxDay = day;
                    maxFlights = flights;
                }
            }
            System.out.println(maxDay);
            System.out.println(maxFlights);
        }
    }
}