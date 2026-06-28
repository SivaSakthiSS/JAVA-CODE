import java.util.Scanner;
public class sumprime{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int n = s.nextInt();
        int sum=0;
        while(n>0){
            int digit=n%10;
            if(prime(digit))
            sum=sum+digit;
            n=n/10;

        }

        System.out.print(sum);

        

    }
    public static boolean  prime(int n){
        if(n<=0){
            return false;
        }
        for(int i=2;i<=n/2;i++){
            if(n%i==0){
                return true;
            }
        }
        return true;

    }
}