import java.util.Scanner;

public class  ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public int askInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input, please enter a number.");
                scanner.next();
            }
        }
    }
}