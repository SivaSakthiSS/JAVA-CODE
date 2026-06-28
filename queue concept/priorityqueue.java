import java.util.*;
public class priorityqueue {
    public static void main(String[] args) {
     PriorityQueue<Integer> queue = new PriorityQueue<>();

        // Add elements to the queue
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
       while (!queue.isEmpty()) {
            System.out.print(queue.poll() +" ");
        }
    }
}