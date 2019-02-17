package fourth_task;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        boolean stopReading = true;
        String allLine = "";

        while (stopReading) {

            Scanner scanner = new Scanner(System.in);
            String word = scanner.nextLine().trim();
            if (word.isEmpty()){
                stopReading = false;
            }

            allLine = allLine  + " " + word;
        }

        Stream<String> line = Arrays.stream(allLine.trim().split(" "));

        long numberOfUniqueWords = line.distinct().count();
        System.out.println(numberOfUniqueWords);

        line.distinct().sorted().forEach(System.out::println);

        Map<String, Long> wordCount = line.collect(Collectors.groupingBy(String::trim,Collectors.counting()));
        for (Map.Entry<String,Long> item : wordCount.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }

        Map<String,Long> letterCount =
                line.map(w -> w.split(""))
                        .flatMap(Arrays::stream)
                        .filter(l -> l.equals(l.toLowerCase()))
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        for (Map.Entry<String,Long> item : letterCount.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }
    }
}
