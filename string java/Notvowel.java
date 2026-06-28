import java.util.Scanner;
public class Notvowel{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        fun(str);
    }
    public static void fun(String str){
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch!='a'&&ch!='e'&&ch!='i'&&ch!='o'&&ch!='u'&&ch!='A'&&ch!='E'&&ch!='I'&&ch!='O'&&ch!='U'){
               System.out.print(ch); 
        }
   
    }
}
}