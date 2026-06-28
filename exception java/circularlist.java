import java.util.*;
class node{
    int data;
    node next;
    public node(int data){
        this.data=data;
        this.next=null;
    }
}
public class circularlist{
    public static node head=null;
    public static node temp=null;
     public static node tail=null;
    public static void create(int data){
        node newnode=new node(data);
        if(head==null){
         head=tail=newnode;
         tail=newnode;
         newnode.next=head;
        }
        else{
            tail.next=newnode;
            newnode.next=head;
            tail=newnode;

        }
        tail.next=head;
    }
    public static void display(node head){
        if(head==null){
            System.out.print("list is empty");
        }
          temp=head;
          while (temp!=tail) { 
           System.out.println(temp.data+" ") ;
            temp=temp.next;
          }
          System.out.print(temp.data);
    }
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        while (true) { 
            String str=s.next();
        try {
            create(Integer.parseInt(str));
        } 
        catch (Exception e) {
             break;
        }
    }
    display(head);

    }
}
