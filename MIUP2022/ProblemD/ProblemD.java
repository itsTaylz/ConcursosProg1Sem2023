import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ProblemD {

    private static final String[] WEEKS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    private static final List<String> MONTHS = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Nov", "Dec");
    private static final Set<String> MONTHS_30 = new HashSet<>(Arrays.asList("Sep", "Apr", "Jun", "Nov"));

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String datestr = sc.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
            Date date = formatter.parse(datestr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            System.out.println(dayOfWeek);

            // String[] split = date.split(" ");
            // int day = Integer.parseInt(split[0]);
            // String month = split[1];
            // int year = Integer.parseInt(split[2]);

            // int weekDay = 0;
            // int yearDiff = year - 1900;
            // int bix = 0;
            // for (int i = 1900; i < year; i++) {
            //     if ((i % 4 == 0 && i % 100 != 0) || (i % 4 == 0 && i % 100 == 0 && i % 400 == 0)) {
            //         bix++;
            //     }
            // }
            // weekDay = (weekDay + yearDiff * 365 + bix) % 7;

            // int monthIndex = MONTHS.indexOf(month);
            // for (int i = 0; i < monthIndex; i++) {
            //     String m = MONTHS.get(i);
            //     if (MONTHS_30.contains(m))
            //         weekDay = (weekDay + 30) % 7;
            //     else if (m.equals("Feb")) {
            //         int days = 28;
            //         if ((year % 4 == 0 && year % 100 != 0) || (year % 4 == 0 && year % 100 == 0 && year % 400 == 0))
            //             days++;
            //         weekDay = (weekDay + days) % 7;
            //     } else 
            //         weekDay = (weekDay + 31) % 7;
            // }
            
            // weekDay = (weekDay + day - 1) % 7;
            // System.out.println(WEEKS[weekDay]);
        }
    }
}