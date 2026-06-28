public class samplecode{
    public static void main(String[] args){
        System.out.println(fun(10,10));

    }
    public static int fun(int a, int b){
        if(a>0 && b>0){
            return 3 + fun(2,0) + fun (0,b-5);
        }
        return a+b;
    }
    
}