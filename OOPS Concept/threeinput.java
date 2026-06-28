public class threeinput {
    public  int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return add(a, b) + c;
    }
        public static void main(String[] args) {
        threeinput obj = new threeinput();
        System.out.println(obj.add(20, 70, 30)); 
    }
}