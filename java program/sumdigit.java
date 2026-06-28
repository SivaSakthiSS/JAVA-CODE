import java.util.Scanner;
public class sumdigit{
    public static void main(String [] args){
        Scanner s=new Scanner (System.in);
        System.out.println("enter a number");
        int n = s.nextInt();
        System.out.println(fun(n));

    }
    public static int fun (int n){
        int sum = 0;
        while (n>0){
            int siva = n%10;
            sum = sum + siva;
            n = n/10;
        }
        return sum;
    }


}
