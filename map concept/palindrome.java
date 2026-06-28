import java.util.Scanner;
public class palindrome{
    public static void main(String[] arg){
        Scanner s= new Scanner(System.in);
        int a=s.nextInt();
        System.out.print(fun(a));
    }
    public static int fun(int a){
        int sum=0;
        int original=a;
        while(a>0){
        int digit =a%10;
        sum=sum*10+digit;
        a=a/10;
     }
     if(original==sum){
        System.out.print("is palindrome");
     }
     else{
        System.out.print("is not prime");
     }
    return sum;
}
}