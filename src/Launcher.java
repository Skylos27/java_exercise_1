import java.util.List;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Welcome to the 42java prompt. Do not type help, I would not help you!!!");

        List<Command> commands = List.of(
                new Quit(),
                new Fibo(),
                new Freq(),
                new Predict()
        );

        Scanner scanner = new Scanner(System.in);
        while(true) {
            String instruction = scanner.nextLine();

            boolean found = false;
            for (Command i : commands) {
                if (i.name().equals(instruction)) {
                    if (!i.run(scanner)) {
                        scanner.close();
                        return;
                    }
                    found = true;
                    break;
                }
            }

            if (!found)
                System.out.println("Unknown command");

        }
    }

}