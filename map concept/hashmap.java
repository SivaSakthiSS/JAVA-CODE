import java.util.*;
public class hashmap{
    public static void main(String[] args){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("apple", 5);
        map.put("banana", 3);
        map.put("orange", 8);
        System.out.println(map);
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}