import java.util.Scanner;
public class binarytodeci{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        System.out.print(fun(n));
    }
    public static int fun(int n){
        int result=0;
        int base=1;
        while(n>0){
        int digit=n%10;
        result=digit*base+result;
        base=base*2;
        n=n/10;
    }
    return result;
}
}