import java.util.*;
class node{
    int data;
    node pre;
    node next;
    public node(int data){
        this.data=data;
        this.pre=pre;
        this.next=next;
    }
}
public class Doublelink{
    public static node head=null;
    public static node temp=null;
    public static void create(int data){
        node newnode=new node(data);
        if(head==null){
         head=temp=newnode;
        }
        else{
            temp.next=newnode;
            newnode.pre=temp;
            temp=newnode;
        }
    }
    public static void display(node head){
        if(head==null){
            System.out.print("list is empty");
        }
          temp=head;
          while (temp!=null) { 
           System.out.println(temp.data+" ") ;
            temp=temp.next;
          }
    }
    public static void insert_begening(int data){
        node newnode=new node(data);
        newnode.next=head;
        head=newnode;
    }
   public static void insert_end(int data){
        node newnode=new node(data);
        head=temp;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
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
