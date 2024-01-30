package ozon_contest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Battleships {

    public static void main(String[] args) throws IOException {
        String inputDirName = "src/ozon_contest/input/battleships/";

        var inputFiles = Utils.processFiles(inputDirName);

        for (var f : inputFiles) {
            var result = new ArrayList<String>();
            System.out.println(">>>>>>>>>>>>>>FILE: "+f);
            try(var reader = Files.newBufferedReader(Paths.get(inputDirName+f))) {
                int n = Integer.parseInt(reader.readLine());
                String line;
                while((line = reader.readLine()) != null) {
                    Map<String, Integer> map = new HashMap<>();
                    String[] ships = line.split(" ");
                    for (var s : ships) {
                        if (map.containsKey(s)) {
                            map.put(s, map.get(s)+1);
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
            }
            for (var x : result) {
                System.out.println(x);
            }

            Utils.showAnswer(inputDirName, f);
        }
    }



}
