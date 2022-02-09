import java.util.Scanner;

public class Launcher {
    public static void main(String[] args)
    {
        System.out.println("Hello " + (args.length > 0 ? args[0] : "World"));
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        while (!command.equals("quit"))
        {
            System.out.println("Unknown command");
            command = scanner.next();
        }
    }
}
