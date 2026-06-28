import java.util.*;
public class arraylist{
    public static void main(String[] args){
    ArrayList a=new ArrayList();
    a.add(20);
    a.add('m');
    a.add("user name");
    a.add(765.986f);
    System.out.println(a);
    for(int i=0;i<a.size();i++){
        System.out.print(a.get(i)+" ");
    }
    }

}