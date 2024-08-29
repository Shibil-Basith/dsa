import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// Node class
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

// QueueNode class for level-order traversal
class QueueNode {
    Node[] queue;
    int front, rear, size;

    public QueueNode(int capacity) {
        queue = new Node[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(Node node) {
        if (size == queue.length) {
            System.out.println("Queue is full");
            return;
        }
        queue[rear] = node;
        rear = (rear + 1) % queue.length;
        size++;
    }

    public Node dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        Node node = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return node;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}


// BinaryTree class
class BinaryTree {
    Node root;

    // Insert node using level-order traversal
    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }

        QueueNode queue = new QueueNode(10);
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node current = queue.dequeue();

            if (current.left == null) {
                current.left = newNode;
                break;
            } else {
                queue.enqueue(current.left);
            }

            if (current.right == null) {
                current.right = newNode;
                break;
            } else {
                queue.enqueue(current.right);
            }
        }
    }

    // Level-order search
    public boolean levelOrderSearch(int value) {
        if (root == null) return false;

        QueueNode queue = new QueueNode(10);
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node current = queue.dequeue();
            if (current.data == value) {
                return true;
            }

            if (current.left != null) queue.enqueue(current.left);
            if (current.right != null) queue.enqueue(current.right);
        }
        return false;
    }

    // Inorder search
    public boolean inorderSearch(int value) {
        return inorderSearch(root, value);
    }

    private boolean inorderSearch(Node node, int value) {
        if (node == null) return false;
        if (inorderSearch(node.left, value)) return true;
        if (node.data == value) return true;
        return inorderSearch(node.right, value);
    }

    // Preorder search
    public boolean preorderSearch(int value) {
        return preorderSearch(root, value);
    }

    private boolean preorderSearch(Node node, int value) {
        if (node == null) return false;
        if (node.data == value) return true;
        if (preorderSearch(node.left, value)) return true;
        return preorderSearch(node.right, value);
    }

    // Postorder search
    public boolean postorderSearch(int value) {
        return postorderSearch(root, value);
    }

    private boolean postorderSearch(Node node, int value) {
        if (node == null) return false;
        if (postorderSearch(node.left, value)) return true;
        if (postorderSearch(node.right, value)) return true;
        return node.data == value;
    }
}

// Main class
public class p31{
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        int val, choice;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert Node");
            System.out.println("2. Search in Level Order");
            System.out.println("3. Search in In-Order");
            System.out.println("4. Search in Pre-Order");
            System.out.println("5. Search in Post-Order");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the number to insert into the tree:");
                    val = sc.nextInt();
                    tree.insert(val);
                    break;
                case 2:
                    System.out.println("Enter the value to search for in level-order:");
                    val = sc.nextInt();
                    boolean foundLevelOrder = tree.levelOrderSearch(val);
                    System.out.println("Value " + (foundLevelOrder ? "found" : "not found") + " in level-order.");
                    break;
                case 3:
                    System.out.println("Enter the value to search for in inorder:");
                    val = sc.nextInt();
                    boolean foundInOrder = tree.inorderSearch(val);
                    System.out.println("Value " + (foundInOrder ? "found" : "not found") + " in inorder.");
                    break;
                case 4:
                    System.out.println("Enter the value to search for in preorder:");
                    val = sc.nextInt();
                    boolean foundPreOrder = tree.preorderSearch(val);
                    System.out.println("Value " + (foundPreOrder ? "found" : "not found") + " in preorder.");
                    break;
                case 5:
                    System.out.println("Enter the value to search for in postorder:");
                    val = sc.nextInt();
                    boolean foundPostOrder = tree.postorderSearch(val);
                    System.out.println("Value " + (foundPostOrder ? "found" : "not found") + " in postorder.");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

