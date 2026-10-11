import java.util.Arrays;

// Searching component: linear search and binary search (both count steps)
public class SearchOperations {
    private int steps = 0;

    public int getSteps() {
        return steps;
    }

    // Checks items one by one. Time: O(n)
    public int linearSearch(int[] arr, int size, int key) {
        steps = 0;
        for (int i = 0; i < size; i++) {
            steps++;
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    // Array MUST be sorted. Cuts the search area in half each time. Time: O(log n)
    public int binarySearch(int[] arr, int size, int key) {
        steps = 0;
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            steps++;
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Submenu. Uses the numbers stored in the Array component.
    public void menu(ArrayOperations arrayOps) {
        int choice;
        do {
            System.out.println("\n------------- SEARCHING OPERATIONS -------------\n");
            System.out.println("(Uses the numbers from Array Operations)\n");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Compare Linear and Binary Search");
            System.out.println("4. Return to Main Menu");
            choice = InputHelper.readInt("\nEnter your choice: ");
            System.out.println();

            if (choice >= 1 && choice <= 3) {
                if (arrayOps.getSize() == 0) {
                    System.out.println("Array is empty! Add numbers in Array Operations first.");
                    continue;
                }
                int key = InputHelper.readInt("Enter value to search: ");
                int[] arr = arrayOps.toArray();
                int size = arr.length;

                if (choice == 1) {
                    int index = linearSearch(arr, size, key);
                    System.out.println(index == -1 ? key + " not found." : key + " found at position " + index);
                    System.out.println("Steps: " + steps);
                    Results.add("Linear Search for " + key + ": steps = " + steps);
                } else {
                    // Binary search needs a sorted array, so we sort a copy
                    Arrays.sort(arr);
                    System.out.println("Sorted array used: " + Arrays.toString(arr));
                    int index = binarySearch(arr, size, key);
                    if (choice == 2) {
                        System.out.println(index == -1 ? key + " not found." : key + " found at position " + index + " (in sorted array)");
                        System.out.println("Steps: " + steps);
                        Results.add("Binary Search for " + key + ": steps = " + steps);
                    } else {
                        int binarySteps = steps;
                        linearSearch(arr, size, key);
                        int linearSteps = steps;
                        System.out.println("Linear Search steps: " + linearSteps);
                        System.out.println("Binary Search steps: " + binarySteps);
                        Results.add("Search compare for " + key + ": linear = " + linearSteps + " steps, binary = " + binarySteps + " steps");
                    }
                }
            } else if (choice != 4) {
                System.out.println("Invalid choice! Enter 1 to 4.");
            }
        } while (choice != 4);
    }
}
