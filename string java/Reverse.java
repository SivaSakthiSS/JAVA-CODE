
import java.util.Scanner;

public class Reverse{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        StringBuffer sb=new StringBuffer(str);
        sb.reverse();
        String str2=new String(sb);
        System.out.print(str2);
        
    }
}
