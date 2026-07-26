package opps;

class parent{
    int id;
    String name;
    String color="White";

    public parent() {
        System.out.println("Constructur of parrent class");
    }
    
    void display(){
        System.out.println("Parent class method ");
    }
}

class child extends parent{
    int age;
    String name;
    String color="Black";

    public child(){
        System.out.println("Child class constructor.");
    }

    public void display(){
        System.out.println("Child class method.");
    }
}


public class super_keyword {
    public static void main(String[] args) {
        child c1=new child();
        c1.display();
    }
}
