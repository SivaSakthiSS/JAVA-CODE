import java.util.Scanner;
public class power{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int a=s.nextInt();
        int b=s.nextInt();
        System.out.print(fun(a,b));
    }
    public static int fun(int a,int b){
       int result=1;
       for(int i=1;i<=b;i++){
          result=result*a;
       }
       return result;
    }
}