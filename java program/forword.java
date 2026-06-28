import java.util.Scanner;
public class forword{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        fun(a,b);
        System.out.println(fun (a,b));


}
public static int fun(int a,int b) {
    int num =1;
    for (int i = 1; i<= b; i++) {
        num = num*a;

         }
         return num;

    
}
    



}
