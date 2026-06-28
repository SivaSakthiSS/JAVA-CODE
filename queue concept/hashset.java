import java.util.*;
public class hashset {
    public static void main(String[] args) {
     LinkedHashSet<String> d = new LinkedHashSet<>();

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