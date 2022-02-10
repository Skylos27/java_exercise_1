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

public class Launcher {
    public static void main(String[] args)
    {
        System.out.println("Hello " + (args.length > 0 ? args[0] : "World"));
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (!command.equals("quit"))
        {
            if (command.equals("fibo"))
            {
                System.out.println("Entrez le terme souhaité : ");
                int n = scanner.nextInt();
                System.out.println("Fibo(" + n + ") = " + fibo(n));
            }
            else if (command.equals("freq"))
            {
                System.out.println("Entrez le chemin du fichier à lire : ");
                String pathstr = scanner.nextLine();
                freq(pathstr);
            }
            else
                System.out.println("Unknown command");
            command = scanner.next();
        }
    }

    public static int fibo(int n)
    {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibo(n - 1) + fibo(n - 2);
    }

    private static void freq(String pathstr) {
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
    }
}
