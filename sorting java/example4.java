import java.util.Scanner;
public class example4{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.close();
        System.out.print(fun(n));
    }

    public static int fun(int n){
        int temp = n;
        int rev = 0;
        while(temp > 0){
            int digit = temp % 10;
            rev = rev * 10 + digit;
            temp = temp / 10;
        }
        return rev;
    }
}

