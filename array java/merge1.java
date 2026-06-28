import java.util.Scanner;
public class merge1{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.print("enter the elements:");
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){

        }
        sort(arr,0,n-1);
    }
    public static void sort(int[] arr,int low,int high){
         if(low>=high){

         }
         int mid=(low+high)/2;
         sort(arr,low,mid);
         sort(arr,mid+1,high);
         merge();
    }

    private static void merge() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
        
}