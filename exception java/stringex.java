public class stringex{
    public static void main(String[] args) {
        String s1="Siva";
       for(int i=0;i<=s1.length();i++){
        try {
            System.out.println(s1.charAt(i)+" ");
        } catch (Exception e) {
            System.out.println(e);
        }
       }
       System.out.println("good mornig siva ");
    }
}
