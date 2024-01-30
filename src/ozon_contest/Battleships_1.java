package ozon_contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Battleships_1 {

    public static void main(String[] args) throws IOException {

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            var result = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                String line = reader.readLine();
                Map<String, Integer> map = new HashMap<>();
                String[] ships = line.split(" ");
                for (var s : ships) {
                    if (map.containsKey(s)) {
                        map.put(s, map.get(s) + 1);
                    } else {
                        map.put(s, 1);
                    }
                }
                if (map.containsKey("4") && map.get("4") == 1 && map.containsKey("3") && map.get("3") == 2 && map.containsKey("2") && map.get("2") == 3 && map.containsKey("1") && map.get("1") == 4) {
                    result.add("YES");
                } else {
                    result.add("NO");
                }
            }
            for (var x : result) {
                System.out.println(x);
            }
        }
    }
}
