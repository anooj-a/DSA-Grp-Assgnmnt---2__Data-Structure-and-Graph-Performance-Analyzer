// Linked List component (singly linked list)
public class MyLinkedList {

    // Each node holds a value and a link to the next node
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head = null;

    public void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        System.out.println(value + " inserted at the beginning.");
    }

    public void insertAtEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println(value + " inserted at the end.");
    }

    public void delete(int value) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.data == value) {
            head = head.next;
            System.out.println(value + " deleted.");
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println(value + " not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println(value + " deleted.");
        }
    }

    public void search(int value) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        int position = 0;
        while (temp != null) {
            if (temp.data == value) {
                System.out.println(value + " found at position " + position + " (steps: " + (position + 1) + ")");
                return;
            }
            temp = temp.next;
            position++;
        }
        System.out.println(value + " not found (steps: " + position + ")");
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void menu() {
        int choice;
        do {
            System.out.println("\n------------ LINKED LIST OPERATIONS ------------\n");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("5. Display");
            System.out.println("6. Return to Main Menu");
            choice = InputHelper.readInt("\nEnter your choice: ");
            System.out.println();

            switch (choice) {
                case 1:
                    insertAtBeginning(InputHelper.readInt("Enter value: "));
                    break;
                case 2:
                    insertAtEnd(InputHelper.readInt("Enter value: "));
                    break;
                case 3:
                    delete(InputHelper.readInt("Enter value to delete: "));
                    break;
                case 4:
                    search(InputHelper.readInt("Enter value to search: "));
                    break;
                case 5:
                    display();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid choice! Enter 1 to 6.");
            }
        } while (choice != 6);
    }
}
