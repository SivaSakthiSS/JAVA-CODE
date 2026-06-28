import java.util.Scanner;
public class example88{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();// int replace"long" methord
        System.out.println(fun(n));

    }
    public static int fun(int n){// long
        int count = 0;
        while(n>0){
            n = n/10;
            count++;
        }
        return count;
    }

}