class Adhar{
    private long adharnum;
    public void setadharnum(long adharnum){
        this.adharnum = adharnum;
    }
    public long getname(){
        return adharnum;
    }
}
public class Adharnumber{
    public static void main(String[] args){
        Adhar ob=new Adhar();
        ob.setadharnum(638792348747L);
    
    System.out.print("ADHAR NUMBER :"+ob.getname());
}
}
