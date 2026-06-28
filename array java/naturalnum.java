import java.util.Scanner;
public class naturalnum{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n = s.nextInt();
        System.out.print(fun(n));

    }
    public static int fun(int n){
        if(n==0){
            return 0;
        }
        return n+fun(n-1);
    }
}