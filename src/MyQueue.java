// Queue component (FIFO) using a circular array
public class MyQueue {
    private int[] items = new int[10];
    private int front = 0;
    private int count = 0;

    public boolean isEmpty() {
        return count == 0;
    }

    public void enqueue(int value) {
        if (count == items.length) {
            System.out.println("Queue is full!");
            return;
        }
        int rear = (front + count) % items.length;
        items[rear] = value;
        count++;
        System.out.println(value + " added to the queue.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue. (Queue Underflow)");
            return;
        }
        System.out.println(items[front] + " removed from the queue.");
        front = (front + 1) % items.length;
        count--;
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Nothing at the front.");
            return;
        }
        System.out.println("Front item: " + items[front]);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue (front -> rear): ");
        for (int i = 0; i < count; i++) {
            System.out.print(items[(front + i) % items.length] + " ");
        }
        System.out.println();
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\n--------------- QUEUE OPERATIONS ---------------\n");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek / Front");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            choice = InputHelper.readInt("\nEnter your choice: ");
            System.out.println();

            switch (choice) {
                case 1:
                    enqueue(InputHelper.readInt("Enter value to enqueue: "));
                    break;
                case 2:
                    dequeue();
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
