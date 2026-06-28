import java.util.Scanner;

class node {
    int data;
    node next;

    public node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class stacklink {

    public static node top = null;
    public static void push(int data) {
        node newnode = new node(data);
        newnode.next = top;
        top = newnode;
        System.out.println(data + " pushed into stack");
    }
    public static int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return 0;
        }
        int element = top.data;
        top = top.next;
        return element;
    }
    public static int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return 0;
        }
        return top.data;
    }
    public static boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter your choice:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. IsEmpty");
            System.out.println("5. Exit");

            int choice = s.nextInt();

            if (choice == 1) {
                System.out.println("Enter element to push:");
                int data = s.nextInt();
                push(data);
            }
            else if (choice == 2) {
                int popped = pop();
                if (popped != -1)
                    System.out.println("Popped element: " + popped);
            }
            else if (choice == 3) {
                int topElement = peek();
                if (topElement != -1)
                    System.out.println("Top element: " + topElement);
            }
            else if (choice == 4) {
                if (isEmpty())
                    System.out.println("Stack is empty");
                else
                    System.out.println("Stack is not empty");
            }
            else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            }
            else {
               break;
            }
    }
}
}
