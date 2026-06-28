import java.util.Scanner;
public class Recurrsion1{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        System.out.print(fifo(n1,n2));
    }
    public static int fifo(int n1, int n2){
        if(n2 == 0){
            return 1;
        }
        return n1 * fifo(n1,n2-1);
            
  }
}