import java.util.Scanner;
public class example{
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            int n1 = s.nextInt();
            int n2 = s.nextInt();
            System.out.println(power(n1, n2));
        }
    }
    public static int power(int n1,int n2){
        if(n2==0){
            return 1;
        } 
        
        return n1*power(n1,n2-1);
    }

}