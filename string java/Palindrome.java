
import java.util.Scanner;

public class Palindrome{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        StringBuffer sb=new StringBuffer(str);
        sb.reverse();
        String str2=new String(sb);
        boolean var=str.equals(str2);
        if(var)
        System.out.print("pallindrome");
        else
        System.out.print("is not a palindrome");
    }
}