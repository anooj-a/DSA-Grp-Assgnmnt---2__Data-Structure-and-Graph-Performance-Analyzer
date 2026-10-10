import java.util.ArrayList;

// Stores results from all operations so option 8 can show them
public class Results {
    private static ArrayList<String> list = new ArrayList<>();

    public static void add(String text) {
        list.add(text);
    }

    public static void showAll() {
        System.out.println("\n=============================================");
        System.out.println("              ALL RESULTS");
        System.out.println("=============================================");
        if (list.isEmpty()) {
            System.out.println("No results yet. Try some operations first.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }
}
