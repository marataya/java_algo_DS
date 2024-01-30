package ozon_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidDate_1 {

    public static boolean has31Days(int month) {
        switch (month) {
            case 1: // January
            case 3: // March
            case 5: // May
            case 7: // July
            case 8: // August
            case 10: // October
            case 12: // December
                return true;
            default:
                return false;
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) throws IOException {

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                String result = "YES";
                String line = reader.readLine();
                String[] numbers = line.split(" ");
                int day = Integer.parseInt(numbers[0]);
                int month = Integer.parseInt(numbers[1]);
                int year = Integer.parseInt(numbers[2]);
                if (day > 28) {
                    if (month == 2 && !isLeapYear(year)) {
                        result = "NO";
                    } else if (month == 2 && isLeapYear(year)) {
                        result = day == 29 ? "YES" : "NO";
                    } else if (!has31Days(month)) {
                        result = day > 30 ? "NO" : "YES";
                    }
                }
                System.out.println(result);
            }
        }

    }
}
