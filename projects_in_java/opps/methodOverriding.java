package opps;

class bank{
    void Roi(){
        System.out.println("ROI  of Bank is :-" + 5.4 + "%");
    }
}
class ICIC extends bank{
     void Roi(){
        System.out.println("ROI  of Icic is :-" + 8.4 + "%");
        super.Roi(); //to call parent class method
    }
    
}

public class methodOverriding {
    public static void main(String[] args) {
        ICIC b1=new ICIC();
        b1.Roi();
    }
}
