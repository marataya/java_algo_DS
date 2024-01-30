package ozon_contest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

public class ValidDate {

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

        String inputDirName = "src/ozon_contest/input/valid_date/";

        var inputFiles = Utils.processFiles(inputDirName);

        for (var f : inputFiles) {
            System.out.println(">>>>>>>>>>>>>>FILE: " + f);
            try (var reader = Files.newBufferedReader(Paths.get(inputDirName + f))) {
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

            Utils.showAnswer(inputDirName, f);
        }

    }
}
