package ozon_contest;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class Utils {

    @NotNull
    public static ArrayList<String> processFiles(String dir) throws IOException {
        var inputFiles = new ArrayList<String>();
        var fileNames = new ArrayList<String>();

        Path inputDir = Paths.get(dir); // Replace with your directory path
        try (var stream = Files.newDirectoryStream(inputDir)) {
            for (Path entry : stream) {
                var filename = entry.toString();
                fileNames.add(filename.substring(filename.lastIndexOf(File.separator)+1));
            }
        }

        for (var f : fileNames) {
            if (!Pattern.compile(".+\\..+").matcher(f).matches()) {
                inputFiles.add(f);
            }
        }
        Collections.sort(inputFiles, (num1, num2) -> {
            int int1 = Integer.parseInt(num1);
            int int2 = Integer.parseInt(num2);
            return Integer.compare(int1, int2);
        });
        return inputFiles;
    }

    public static void showAnswer(String dirName, String f) throws IOException {
        System.out.println("---------------ANSWER-------------------");
        var sb = new StringBuilder();
        sb.append(dirName).append(f).append(".a");
        try(var reader = Files.newBufferedReader(Paths.get(sb.toString()))) {
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

}
