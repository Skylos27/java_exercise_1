import java.util.Scanner;

public class Fibo implements Command{
    @Override
    public String name() {
        return "fibo";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Entrez le terme souhaité : ");
        int n = scanner.nextInt();
        System.out.println("Fibo(" + n + ") = " + fibo(n));
        return false;
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
