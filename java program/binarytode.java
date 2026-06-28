import java.util.Scanner;
public class binarytode{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fun(n));

    }
    public static int fun (int n){
        int num = 0;
        int k =1;
        while(n>0){
            int siva = n%10;
            num = siva*k+num;
            n=n/10;
            k=k*2;
        }
        return num;
    }
}