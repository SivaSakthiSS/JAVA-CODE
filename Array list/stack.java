import java.util.*;
public class stack{
    public static void main(String[] args){
    Stack<Integer> s=new Stack <Integer>();
    s.push(10);
    s.push(3);
    s.push(4);
    s.push(45);
    System.out.println(s);
    while(!s.isEmpty()){
        System.out.print(s.pop()+" ");
    }
    }

}