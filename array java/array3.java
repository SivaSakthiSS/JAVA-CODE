import java.util.Scanner;
public class array3{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("enter the number;");
        int n = s.nextInt();
        System.out.print(sum(n));
    }
    public static int sum(int n){
        
        if(n == 0){
            return 0;
        }
     return (n%10)+sum(n/10);
}
}