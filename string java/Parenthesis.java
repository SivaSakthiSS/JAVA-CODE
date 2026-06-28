import java.util.Scanner;
public class Parenthesis{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        fun(str);
    }
    public static void fun(String str){
         int len=str.length();
         boolean var=true;
         char[] b=new char[len];
         for(int i=0;i<len;i++){
            b[i]='*';
            }
            int j=0;
            for(int i=0;i<len;i++){
                char ch=str.charAt(i);
                if( ch=='('||ch=='['||ch=='{'){
                    b[j]=ch;
                    j++;
                }
                if(j==0)
                    var=false;
                else if(b[j-1]=='['&& ch==']'||b[j-1]=='('&& ch==')'||b[j-1]=='{'&& ch=='}'){
                    b[j-1]='*';
                    j--;
                }
            }
               for(int i=0;i<j;i++){
                if(b[i]!='*'){
                    var=false;
                    break;
                }
            }
            System.out.println(var);
        }
    }
