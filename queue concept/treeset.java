import java.util.*;
public class treeset {
    public static void main(String[] args) {
     TreeSet<String> d = new TreeSet<>();

        d.add("college");
        d.add("student");
        d.add("bus");
        d.add("college");
        System.out.println(d);
        Iterator<String> d1 = d.iterator();
       while (d1.hasNext()) {
            System.out.print(d1.next() +" ");
        }
    }
}