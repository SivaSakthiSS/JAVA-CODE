import java.util.Scanner;

public class reverse{
    public static void main (String [] args){
        Scanner s=new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fun(n));


    }
    public static int fun (int n){
        int rev= 0;
        while(n>0){ 
            rev = rev*10 + n%10;
            n = n/10 ;
        }
        return rev;
}
}