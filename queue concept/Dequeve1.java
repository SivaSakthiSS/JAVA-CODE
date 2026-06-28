import java.util.*;
public class Dequeve1 {
    public static void main(String[] args) {
     Deque<String> d = new LinkedList<>();

        // Add elements to the queue
        d.offer("76");
        d.offer("98");
        d.offerFirst("5");
        d.removeLast();
       while (!d.isEmpty()) {
            System.out.print(d.poll() +" ");
        }
    }
}