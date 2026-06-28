import java.util.Scanner;
public class factorial{
    public static void main(String[] args){
        try (Scanner s = new Scanner(System.in)) {
            int n = s.nextInt();
            System.out.print(fifo(n));
        }
    }
    public static int fifo(int n){
        if(n == 1){
            return 1;       
        }
        return n * fifo(n-1);
    }
}