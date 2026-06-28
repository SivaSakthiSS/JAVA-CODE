import java.util.Scanner;
public class sumof{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        System.out.print(fun(n));
    }
    public static int fun(int n){
        if(n==1){
            return 1;
        }
    
    return n* fun(n-1);
  }
}
