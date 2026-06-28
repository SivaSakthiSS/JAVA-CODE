
import java.util.Scanner;

public class prime{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      System.out.println("enter a number");
        boolean res= fun(n); // created a boolean variable"res"
        if(res)
        System.out.println("prinme nummer");
        else
        System.out.println("is not a prime");

    }
    public static boolean  fun(int n){
    if(n==1){
        return false;
    }
    for(int i = 2;i <=n-1;i++){ //logic code 7 % 2=1 
        if(n % i==0)
        return false;
        if(n % i ==1)
        return true;
    }
    return true;
    }

}