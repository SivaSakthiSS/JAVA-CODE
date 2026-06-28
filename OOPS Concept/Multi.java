class ceo{
    public static void think(){
        System.out.println("think big");
    }
}
class college extends ceo{ 
    static String str="batch";
    public static void fun(){
        System.out.println("Svhec");
    }
}
public class Multi extends college{
    public static void good(){
        System.out.println("god morning");
    }
       public static void main(String[] args){
        Multi.think();
        Multi.good();
        System.out.print(Multi.str);
       }    
  }
    
