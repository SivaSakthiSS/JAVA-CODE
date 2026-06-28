import java.util.Scanner;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
    }
}

public class stacklinked {

    static Node top = null;

    static void push(char ch) {
        Node n = new Node(ch);
        n.next = top;
        top = n;
    }

    static char pop() {
        char x = top.data;
        top = top.next;
        return x;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter string");
        String s = sc.nextLine();
        boolean valid = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[')
                push(ch);

            else if (ch == ')' || ch == '}' || ch == ']') {
                if (top == null) {
                    valid = false;
                    break;
                }

                char open = pop();

                if ((ch == ')' && open != '(') ||
                    (ch == '}' && open != '{') ||
                    (ch == ']' && open != '[')) {
                    valid = false;
                    break;
                }
            }
        }

        if (top != null)
            valid = false;

        if (valid) {
            System.out.println("valid");
        } else {
            System.out.println("invalid");
        }
    }
}
