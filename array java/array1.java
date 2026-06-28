import java.util.Scanner;
public class array1{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        System.out.print("enter element;");
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++){
         arr[i]=s.nextInt(); 
        }
        System.out.print(power(arr));
    }
    public static int power(int[] arr){
        int max = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;

    }
    }

