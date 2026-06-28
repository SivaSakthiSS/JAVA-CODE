import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();

        fun(a, b);

        s.close();
    }

    public static void fun(int a, int b) {
        for (int i = a; i <= b; i++) {
            int num = i;
            int rev = 0;

            while (num > 0) {
                rev = rev * 10 + num % 10;
                num = num / 10;
            }

            if (i == rev) {
                System.out.println(i);
            }
        }
    }
}
