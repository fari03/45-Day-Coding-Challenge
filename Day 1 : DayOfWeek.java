/* Write a function that calculates corresponding day of the week for any particular date in the past or future
# Constraints: 
1<=T<=10^5  
1<=Day<=31    
1<=Month<=12
1<=Year<=2,000,000 
Time Limit: 1sec*/

import java.util.Scanner;

public class DayOfWeek{
    public static String dayOfTheWeek(int day, int month, int year) {
        // Zeller's congruence algorithm
        int q = day;
        int m = month;
        if (m < 3) {
            m += 12;
            year--;
        }
        int k = year % 100;
        int j = year / 100;
        int h = (q + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;
        // h = 0 -> Saturday, h = 1 -> Sunday, ..., h = 6 -> Friday
        String[] daysOfWeek = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        return daysOfWeek[h];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // number of test cases
        while (t-- > 0) {
            int day = scanner.nextInt();
            int month = scanner.nextInt();
            int year = scanner.nextInt();
            String dayOfWeek = dayOfTheWeek(day, month, year);
            System.out.println(dayOfWeek);
        }
        scanner.close();
    }
}
