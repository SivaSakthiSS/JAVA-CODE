import java.util.Scanner;
public class Hexadecimal{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        fun(str);
    }
    public static void fun(String str){
        int sum=0;
        int k=1;
        int len=str.length();
        for(int i=len-1;i>=0;i--){
            char ch=str.charAt(i);
            if(ch>='A' && ch<='F'){
                int y=(int)ch-55;
                sum=sum+(y*k);
            }
            else if(ch>='0' && ch<='9'){
                int y=(int)ch-48;
                sum=sum+(y*k);
            }
            k=k*16;
        }
        System.out.print(sum);
    }
}
