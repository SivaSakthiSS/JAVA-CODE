
import java.util.Scanner;

public class Smallest{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        fun(str);
    }
    public static void fun(String str){
        int min=Integer.MAX_VALUE;
        int len=str.length();
        int count=0;
        int start=0;
        int k=0;
        for(int i=0;i<len;i++){
            char ch=str.charAt(i);
            if(ch!=' '){
                count++;
            }
            else{
                if(count<min){
                    min=count;
                    start=k;
                }
                }
                k=i+1;
                count=0;
            }
            if(count<min){
                min=count;
                start=k;
            }
        System.out.print(str.substring(start, start + min));
}
}


