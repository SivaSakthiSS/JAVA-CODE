class college{
    public void what(){
        System.out.println("cooledg is good");
    }
    public static int fun(int a, int b){
        return a+b;
    }
}
   public class  Overrider extends college{  //OVERRIDING METHORD
         @Override
         public void what(){
            super.what();
            System.out.println("coll coll coll");
            }
         
         public static void main(String[] args){
            Overrider sb=new Overrider();
            sb.what();
            int y=college.fun(4,9);
            System.out.print(y);
         }
   }