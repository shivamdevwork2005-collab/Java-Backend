package opps; // child is a parent // is  a relationship. // child has a parent // has a  relationship.

class parent{
    void display(){
        System.out.println("Parent class method");
        System.out.println();
    }
}

class child extends parent{
    void show(){
        System.out.println("Child class");
    }
}

///////////////************* New class *************/////////////////// 

class Vehical{
    double price;
    double milage;
    String color;

    void display(){
        System.out.println(price);
        System.out.println(milage);
        System.out.println(color);
    }
}

class Car extends Vehical{
    String ftype;
    boolean sunroof;
    String brand;
}


public class inheritance {
    public static void main(String[] args) {
        child c1=new child();
        c1.show();
        c1.display();

        Car car1=new Car();
        car1.brand="suzuki";
        car1.price=1939393993;
        car1.milage=39.4;
        car1.ftype="Disel";
        car1.color="Wine";
        car1.sunroof=true;
        car1.display();
        System.out.println(car1.sunroof);

    }
}












