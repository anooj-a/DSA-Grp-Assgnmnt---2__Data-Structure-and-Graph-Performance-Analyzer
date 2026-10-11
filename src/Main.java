// Main class: shows the main menu and connects all components
public class Main {
    public static void main(String[] args) {
        ArrayOperations arrayOps = new ArrayOperations();
        MyStack stack = new MyStack();
        MyQueue queue = new MyQueue();
        MyLinkedList list = new MyLinkedList();
        SearchOperations searcher = new SearchOperations();
        Graph graph = new Graph();
        PerformanceAnalyzer analyzer = new PerformanceAnalyzer();

        int choice;
        do {
            System.out.println("\n\n===== CIT300 Data Structures and Algortihms (2C) =====");
            System.out.println("\t\t== ** Byte Builders ** ==");
            System.out.println("\n======================================================");
            System.out.println("\t    DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("======================================================\n");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            choice = InputHelper.readInt("\nEnter your choice: ");

            switch (choice) {
                case 1:
                    arrayOps.menu();
                    break;
                case 2:
                    stack.menu();
                    break;
                case 3:
                    queue.menu();
                    break;
                case 4:
                    list.menu();
                    break;
                case 5:
                    searcher.menu(arrayOps);
                    break;
                case 6:
                    graph.menu();
                    break;
                case 7:
                    analyzer.run();
                    break;
                case 8:
                    Results.showAll();
                    break;
                case 9:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Enter 1 to 9.");
            }
        } while (choice != 9);
    }
}
