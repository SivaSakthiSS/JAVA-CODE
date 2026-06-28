import java.util.Scanner;
public class Selectiontsort{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.print("enter the elements:");
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = s.nextInt();
        }
    }
    public static void sort(int[]arr,int n){
        for(int i =0;i<n-1;i++){
            int min_index = 0;
            for(int j=i+1;j<n;j++){
            if(arr[j]<arr[min_index]){
                min_index=j;
            }
        }
        if(min_index!=i){
            int temp=arr[i];
            arr[i]=arr[min_index];
            arr[min_index]=temp;
        }
    }
   
    
     for(int i=0;i<n;i++){
        System.out.print(arr[i]+" ");
}

}
}
