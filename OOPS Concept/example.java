abstract class college{
    public void fun(){
        System.out.println("good morning");
    }
    public abstract int add(int a,int b);

 }
     public class example extends college{
        @Override
        public int add(int a,int b){
            int sum=a+b;
            return sum;
        }
    
    public static void main(String[] args){
        example ob=new example();
        ob.fun();
        System.out.println(ob.add(6,8));
    }

}

