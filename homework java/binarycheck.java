import java.util.Scanner;

public class binarycheck{
    public static void main(String[]args){
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        System.out.println(fun(n1,n2));
    }
    public static int fun(int n1 ,int n2){
        int carry = 0;
        int result = 0;
        int k = 1;
        while(n1 != 0 || n2 != 0){
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            int sum = d1 + d2 + carry;
            int digit = sum % 2;
            carry = sum / 2;
            result += digit * k;
            n1 = n1 / 10;
            n2 = n2 / 10;
            k = k * 10;
        }
        if (carry != 0){
            result += carry * k;
        }
        return result;

    }
}