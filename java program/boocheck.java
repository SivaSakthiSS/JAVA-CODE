import java.util.Scanner;
public class boocheck{
    public static void main (String[] args){
        Scanner s = new Scanner (System.in);
        int n = s.nextInt();
        System.out.println(fun(n));


    }
    public static boolean fun(int n){
        if (n <= 1){
            return false;
      }
      for (int i = 2; i <= n/2; i++) {
        if (n % i == 0)
          return true;
      }
      return true;
    }
}