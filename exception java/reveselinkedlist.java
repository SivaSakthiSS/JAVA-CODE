import java.util.*;
class node{
    int data;
    node next;
    public node(int data){
        this.data=data;
        this.next=null;
    }
}
public class reveselinkedlist{
    public static node head=null;
    public static node temp=null;
    public static void create(int data){
        node newnode=new node(data);
        if(head==null){
            head=temp=newnode;
        }
        else{
            temp.next=newnode;
            temp=newnode;
        }
    }
    public static void display(node head1){
        temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public static void reverse_linked_list(){
           node pre=null;
           node current=head;
           node next=null;
           while(current!=null){
            next=current.next;
            current.next=pre;
            pre=current;
            current=next;
           }
           head=pre;
    }
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        while (true) {
             String str=s.next();
        try {
            create(Integer.parseInt(str));
            
        } catch (Exception e) {
            break;
        }
        }
        System.out.println();
        System.out.println("reversed list");
        reverse_linked_list();
        display(head);
    
    }
}