import java.util.Scanner;
public class backword{
    public static void main(String[] args){
        Scanner s =new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fun(n));
    }
    public static int fun(int n) {
        int num = 1;
        for (int i = n; i>= 2; i--) {
            num = num*n;
            
        }
        return num;
        
    }
}