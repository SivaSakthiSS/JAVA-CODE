import java.util.Scanner;
public class array2{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.print("enter the elements:");
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = s.nextInt();
        }
        
        System.out.print(minimum(arr));

    }
    public static int minimum(int [] arr){
        int min = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }
}
