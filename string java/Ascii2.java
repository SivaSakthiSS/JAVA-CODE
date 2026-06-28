import java.util.Scanner;
public class Ascii2{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        fun(str);
    }
        public static void fun(String str){
        for(int i=0;i<str.length();i++){
            char sb=str.charAt(i);
        if(sb >= 'A' && sb <= 'Z'){
            int y=(int)sb+32;
            System.out.print((char)y);
         }
         else{
            System.out.print(sb);
         }
        }
    }
}
