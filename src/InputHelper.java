import java.util.Scanner;

// Helper class: reads numbers safely so the program does not crash
public class InputHelper {
    private static Scanner sc = new Scanner(System.in);

    // Keeps asking until the user types a whole number
    public static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a whole number.");
            }
        }
    }
}
