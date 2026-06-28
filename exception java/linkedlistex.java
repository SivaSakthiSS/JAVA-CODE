import java.util.*;
class node{
    int data;
    node next;
    public node(int data){
        this.data=data;
        this.next=null;

    } 
}

public class linkedlistex{
     public static node head=null;
     public static node temp=null;
    private static node pre;
    private static int pos1;
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
    public static void display(node head){
        temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    public static void insert_begining(int data){
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

    public static void insert_specific_position(int data, int pos){
        node newnode=new node(data);
        int i=1;
        head=temp;
        while(i<pos){
          temp=temp.next;
          i++;
          newnode.next=temp.next;
          temp.next=newnode;
        }
    }
        public static void delete_begining(){
            if (head==null) {
                System.out.println("list is empty");
            }
            else{           
               head=head.next;
            }    
 
        }
            public static void delete_last() {
                if(head.next==null){
                    head=null;
                }
                else{
    
            while(temp.next!=null){
                pre=temp;
                temp=temp.next;
            }
        }
         pre.next=null;
    }
    public static void delete_specific_position(int data, int pos1){
        node newnode=new node(data);
        int i=1;
        head=temp;
        while(i<pos1){
          temp=temp.next;
          i++;
        }
          newnode.next=temp.next;
          temp.next=newnode;
        }

            
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        while (true) { 
            String str=s.next(); // "7"
            try {
              create (Integer.parseInt(str));    // create(7)
            } 
            catch (NumberFormatException e) {
                    break;
            }
       
        }
        display(head);
        System.out.println();
        System.out.println("inserted begining"); 
        int n=s.nextInt();
        insert_begining(n);
        display(head);
       System.out.println();
        System.out.println("inserted end"); 
        int sb=s.nextInt();
        insert_end(sb);
        display(head); 
        System.out.println();
        System.out.println("insert specific position"); 
        int n2=s.nextInt();
        int pos=s.nextInt();
        insert_specific_position(n2,pos);
        display(head); 
        System.out.println();
        delete_begining();
        display(head);
        System.out.println();
        delete_last();
        display(head);
        System.out.println();
        System.out.println("insert specific position");
        int n3=s.nextInt();
        int pos1=s.nextInt();
        insert_specific_position(n3,pos1);
        display(head);  


  }
     
}