import java.util.Scanner;   
public class throwex{
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int n=s.nextInt();
        try {
            if(n<18){
                throw new ArithmeticException("not valid");
            } else {
                System.out.println("welcome to vote");
            }
        } catch (ArithmeticException e) {
            System.out.println(e);
        }

    }
}
