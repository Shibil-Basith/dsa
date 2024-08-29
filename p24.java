import java.util.Scanner;

// Node class to represent each node in the circular linked list
class Node {
    int data;
    Node next;

    // Constructor to initialize a node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// CircularLinkedList class to represent the circular linked list
class CircularLinkedList {
    Node head;
    Node tail;

    public CircularLinkedList() {
        head = null;
        tail = null;
    }

    // Method to insert a new node at the end of the circular linked list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // Complete the circle
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Complete the circle
        }
    }
    
    // Method to insert a new node at the beginning of the circular linked list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // Complete the circle
        } else {
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
    }

    // Method to display the circular linked list
    public void display() {
        if (head == null) {
            System.out.println("Circular Linked List is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}

// Main class to demonstrate the circular linked list, insert nodes, count nodes, and display the list
public class p24 {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);

        // Insert nodes at the end of the list
        System.out.println("Enter the number of nodes to insert:");
        int ch = 1, data;
        while(ch == 1) {
            System.out.println("Enter the data: ");
            data = scanner.nextInt();
            list.insertAtEnd(data);
            System.out.println("Do you want to enter more elements (1 for yes, 0 for no)?");
            ch = scanner.nextInt();
        }

        // Display the circular linked list after initial insertion
        System.out.println("Circular Linked List after initial insertion:");
        list.display();
        
        // Insert a node at the beginning of the list
        System.out.println("Enter element to insert at the beginning: ");
        data = scanner.nextInt();
        list.insertAtBeginning(data);
        
        // Display the circular linked list after insertion at beginning
        System.out.println("Circular Linked List after insertion at the beginning:");
        list.display();

        // Close the scanner to avoid resource leaks
        scanner.close();
    }
}

