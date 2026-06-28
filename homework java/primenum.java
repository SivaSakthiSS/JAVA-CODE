import java.util.Scanner;

public class primenum {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();  
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (check(i)) {
                count++;
            }
        }

        System.out.println("Prime count: " + count);
        s.close();
    }
    public static boolean check(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
