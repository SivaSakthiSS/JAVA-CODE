import java.util.*;
public class example1 {
    public static void main(String[] args) {
     Queue<Integer> queue = new LinkedList<Integer>();

        // Add elements to the queue
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println(queue.peek());
        queue.poll();
       while (!queue.isEmpty()) {
            System.out.print(queue.poll() +" ");
        }
    }
}