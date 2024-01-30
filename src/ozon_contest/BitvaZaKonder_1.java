package ozon_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.IntStream;


public class BitvaZaKonder_1 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))){
            int t = Integer.parseInt(reader.readLine());
            for (int i = 0; i < t; i++) {

                int n = Integer.parseInt(reader.readLine());
                var tempRange = new ArrayList<Integer>();
                IntStream.rangeClosed(15, 30).forEach(tempRange::add);

                var result = new ArrayList<Integer>();

                for (int j = 0; j < n; j++) {
                    String line = reader.readLine();
                    String sign = line.substring(0, 2);
                    int temp = Integer.parseInt(line.substring(line.length() - 2));

                    if (sign.equals(">=")) {
                        tempRange.removeIf(x -> x < temp);
                    } else {
                        tempRange.removeIf(x -> x > temp);
                    }

                    if (tempRange.size() > 0) {
                        result.add(tempRange.get(0));
                    } else result.add(-1);

                }
                for (var x : result) {
                    System.out.println(x);
                }
                System.out.println();

            }
        }
    }
}
