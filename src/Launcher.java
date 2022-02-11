import java.util.List;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("You have 4 commands available, fibo, freq, predict and quit. Have fun with those !");

        List<Command> commands = List.of(
                new Quit(),
                new Fibo(),
                new Freq(),
                new Predict()
        );

        Scanner scanner = new Scanner(System.in);
        boolean quit = true;
        do {
            String instruction = scanner.nextLine();

            boolean found = false;
            for (var i : commands) {
                if (i.name().equals(instruction)) {
                    if (i.run(scanner))
                        return;
                    quit = false;
                    found = true;
                }
            }

            if (!found)
                System.out.println("Unknown command");

        } while (quit);
    }

}