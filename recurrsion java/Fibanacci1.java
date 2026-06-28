import java.util.Scanner;
public class Fibanacci1{
     public static void main(String[]args){
       try( Scanner s = new Scanner(System.in)){
        int n = s.nextInt();
        System.out.print(fifo(n));
    }
}

    public static int fifo(int n){
        if(n == 0 ||n == 1){
                return 1;
                       
            }
            return fifo(n-1) + fifo(n-2);
    }


}