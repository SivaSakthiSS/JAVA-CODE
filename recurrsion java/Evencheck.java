import java.util.Scanner;
public class Evencheck{
    public static void main(String[] args){
       Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.print(fun(n));
        s.close();


    }
    public static int fun(int n){
        int sum = 0;
        while(n > 0){
           int digit = n % 10;

            if(digit %2==0){
            sum = sum +digit;
            }
            
            n = n/10;
        }
        return sum;


    }
}