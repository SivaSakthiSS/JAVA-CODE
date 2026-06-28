import java.util.*;
public class treemap{
    public static void main(String[] args){
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("apple", 5);
        map.put("banana", 3);
        map.put("orange", 8);
        System.out.println(map);
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}