import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class p22 {
    Node head;

    public p22() {
        this.head = null;
    }

    public void insertAtFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertAtLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void insertAtPosition(int data, int pos) {
        if (pos < 0) {
            System.out.println("Position cannot be negative.");
            return;
        }

        if (pos == 0) {
            insertAtFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < pos - 1; i++) {
            if (current == null) {
                System.out.println("Position exceeds the list");
                return;
            }
            current = current.next;
        }

        if (current == null) {
            System.out.println("Position exceeds the list");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public void removeAtFirst() {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }
        System.out.println(head.data + " removed from the list");
        head = head.next;
    }

    public void removeAtLast() {
        if (head == null) {
            System.out.println("List is empty...");
            return;
        }
        if (head.next == null) {
            removeAtFirst();
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            System.out.println(current.next.data + " removed from list");
            current.next = null;
        }
    }

    public void removeAtPosition(int pos) {
        if (pos < 0) {
            System.out.println("Position cannot be negative.");
            return;
        }

        if (pos == 0) {
            removeAtFirst();
            return;
        }

        Node current = head;
        for (int i = 0; i < pos - 1; i++) {
            if (current == null) {
                System.out.println("Position exceeds list");
                return;
            }
            current = current.next;
        }

        if (current == null || current.next == null) {
            System.out.println("Position exceeds list");
            return;
        }

        System.out.println(current.next.data + " removed from list");
        current.next = current.next.next;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        p22 list = new p22();
        int ch = 1, data, pos;
        System.out.println("Enter elements to the list: ");
        while (ch == 1) {
            System.out.print("Enter data: ");
            data = input.nextInt();
            list.insertAtLast(data);
            System.out.println("Do you want to insert more elements to the list (0 or 1): ");
            ch = input.nextInt();
        }

        System.out.println("List after initial insertion: ");
        list.display();

        while (true) {
            System.out.println("\n\n\nLinked list operations: ");
            System.out.println("1. Insert at first");
            System.out.println("2. Insert at last");
            System.out.println("3. Insert at position");
            System.out.println("4. Remove from first");
            System.out.println("5. Remove from last");
            System.out.println("6. Remove from position");
            System.out.println("7. Display");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            ch = input.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter the data: ");
                    data = input.nextInt();
                    list.insertAtFirst(data);
                    break;
                case 2:
                    System.out.println("Enter the data: ");
                    data = input.nextInt();
                    list.insertAtLast(data);
                    break;
                case 3:
                    System.out.println("Enter the data: ");
                    data = input.nextInt();
                    System.out.println("Enter the position: ");
                    pos = input.nextInt();
                    list.insertAtPosition(data, pos);
                    break;
                case 4:
                    list.removeAtFirst();
                    break;
                case 5:
                    list.removeAtLast();
                    break;
                case 6:
                    System.out.println("Enter the position: ");
                    pos = input.nextInt();
                    list.removeAtPosition(pos);
                    break;
                case 7:
                    list.display();
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }
}

