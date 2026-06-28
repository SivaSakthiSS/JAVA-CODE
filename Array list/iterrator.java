import java.util.*;
public class iterrator{
    public static void main(String[] args){
    ArrayList a=new ArrayList();
    a.add(20);
    a.add('m');
    a.add("user name");
    a.add(765.986f);
    System.out.println(a);
    Iterator it=a.iterator();
    while(it.hasNext()){
        System.out.print(it.next()+" ");
    }
    }

}