// Array component: insert, delete, search, display
public class ArrayOperations {
    private int[] data = new int[20];
    private int size = 0;

    // Insert value at a position (items on the right shift one step)
    public void insert(int value, int position) {
        if (size == data.length) {
            System.out.println("Array is full!");
            return;
        }
        if (position < 0 || position > size) {
            System.out.println("Invalid position! Use 0 to " + size);
            return;
        }
        for (int i = size; i > position; i--) {
            data[i] = data[i - 1];
        }
        data[position] = value;
        size++;
        System.out.println(value + " inserted at position " + position);
    }

    // Delete the item at a position (items on the right shift left)
    public void delete(int position) {
        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        if (position < 0 || position >= size) {
            System.out.println("Invalid position! Use 0 to " + (size - 1));
            return;
        }
        int removed = data[position];
        for (int i = position; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        System.out.println(removed + " deleted from position " + position);
    }

    public void display() {
        if (size == 0) {
            System.out.println("Array is empty!");
            return;
        }
        System.out.print("Array: [ ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("]  (size = " + size + ")");
    }

    // Returns a copy of the used part of the array
    public int[] toArray() {
        int[] copy = new int[size];
        for (int i = 0; i < size; i++) {
            copy[i] = data[i];
        }
        return copy;
    }

    public int getSize() {
        return size;
    }

    public void menu() {
        SearchOperations searcher = new SearchOperations();
        int choice;
        do {
            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            choice = InputHelper.readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    int value = InputHelper.readInt("Enter value: ");
                    int pos = InputHelper.readInt("Enter position (0 to " + size + "): ");
                    insert(value, pos);
                    break;
                case 2:
                    delete(InputHelper.readInt("Enter position to delete: "));
                    break;
                case 3:
                    if (size == 0) {
                        System.out.println("Array is empty!");
                        break;
                    }
                    int key = InputHelper.readInt("Enter value to search: ");
                    int index = searcher.linearSearch(toArray(), size, key);
                    if (index == -1) {
                        System.out.println(key + " not found.");
                    } else {
                        System.out.println(key + " found at position " + index);
                    }
                    break;
                case 4:
                    display();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid choice! Enter 1 to 5.");
            }
        } while (choice != 5);
    }
}
