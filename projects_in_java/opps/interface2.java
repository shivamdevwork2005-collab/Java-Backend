package opps;

// to away from dimond problem.
interface A{
    void run();
}

interface B{
    void run();
}

class C implements A,B{

    public void run(){
        System.out.println("person runs .");
    }
}


public class interface2 {
    public static void main(String[] args) {
        A obj=new C();
        obj.run();
    }
}
