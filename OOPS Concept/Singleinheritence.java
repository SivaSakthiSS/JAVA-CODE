class college{
    String str="batch";
    public void fun(){
        System.out.println("Svhec");
    }
}
public class Singleinheritence extends college{
    public void good(){
        System.out.println("god morning");
    }
       public static void main(String[] args){
        Singleinheritence ob=new Singleinheritence();
        ob.good();
        ob.fun();
        System.out.print(ob.str);
       }    
}