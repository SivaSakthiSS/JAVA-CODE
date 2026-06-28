import java.util.Scanner;
public class array4{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i=0;i < arr.length;i++){
            arr[i]=s.nextInt();
        }
        int k=s.nextInt();
        int index = search(arr,k);
        if(index == -1){
            System.out.print("element not found");
     }
     else
     System.out.print("element found at index"+index); 
}
    public static int search(int [] arr,int k){
        int index=-1;
        for(int i =0;i < arr.length;i++){
            if(arr[i] == k){
             index = i;
            break;
            }
        }
        return index;
        

    }
}
