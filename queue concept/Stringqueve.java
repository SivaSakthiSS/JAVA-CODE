import java.util.*;
public class Stringqueve {
    public static void main(String[] args) {
     PriorityQueue<String> queue = new PriorityQueue<>();

        // Add elements to the queue
        queue.offer("rApple");
        queue.offer("DBanana");
        queue.offer("Zherry");
       while (!queue.isEmpty()) {
            System.out.print(queue.poll() +" ");
        }
    }
}