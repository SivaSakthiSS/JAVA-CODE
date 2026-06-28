import java.util.Scanner;

public class array5 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        System.out.print(result(arr));
    }
    public static int result(int[] arr) {
        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            total = total + arr[i];
        }

        return total;
    }
}
