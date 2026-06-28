import java.util.Scanner;

public class Ascii{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        int sum=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            sum=(int)ch+sum;

        }
        System.out.print(sum);
    }
    }