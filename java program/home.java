import java.util.Scanner;
public class home{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fun(n));
    }
    public static int fun(int n){
        int num = 0;
        for(int i=n;i<=2;i++){}
    
        while(n > 0){
        int digit = n%10;
        num = num + digit;
        n = n/10;
        }
        return num; 
        
        }
    }
 
    

    
