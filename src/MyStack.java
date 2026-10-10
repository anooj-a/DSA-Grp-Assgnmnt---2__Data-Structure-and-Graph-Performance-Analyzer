// Stack component (LIFO) using an array
public class MyStack {
    private int[] items = new int[10];
    private int top = -1;

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (top == items.length - 1) {
            System.out.println("Stack is full! (Stack Overflow)");
            return;
        }
        top++;
        items[top] = value;
        System.out.println(value + " pushed.");
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop. (Stack Underflow)");
            return;
        }
        System.out.println(items[top] + " popped.");
        top--;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Nothing to peek.");
            return;
        }
        System.out.println("Top item: " + items[top]);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.println("Stack (top to bottom):");
        for (int i = top; i >= 0; i--) {
            System.out.println("  | " + items[i] + " |");
        }
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\n--------------- STACK OPERATIONS ---------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            choice = InputHelper.readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    push(InputHelper.readInt("Enter value to push: "));
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    peek();
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
