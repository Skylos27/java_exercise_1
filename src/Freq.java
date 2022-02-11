import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Freq implements Command{
    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Entrez le chemin du fichier à lire : ");
        String pathstr = scanner.nextLine();
        try {
            Path path = Paths.get(pathstr);
            String text = Files.readString(path);
            String[] words = text.split(" ");

            Stream<String> wordStream = Arrays.stream(words);

            Map<String, Long> WordCount = wordStream
                    .filter(string -> !string.isBlank())
                    .map(String::toLowerCase)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            Comparator<Map.Entry<String, Long>> countReversed =
                    Map.Entry.<String, Long>comparingByValue()
                            .reversed();

            String top3 = WordCount.entrySet().stream()
                    .sorted(countReversed)
                    .limit(3)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.joining(" "));

            System.out.println(top3);

        } catch (IOException e) {
            System.out.println("Unreadable file: " + e);
        }
        return false;
    }
}
