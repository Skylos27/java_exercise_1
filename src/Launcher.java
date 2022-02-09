import java.util.Scanner;

public class Launcher {
    public static void main(String[] args)
    {
        System.out.println("Hello " + (args.length > 0 ? args[0] : "World"));
        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        while (!command.equals("quit"))
        {
            if (command.equals("fibo"))
            {
                System.out.println("Entrez le terme souhaité : ");
                int n = scanner.nextInt();
                System.out.println(fibo(n));
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
}
