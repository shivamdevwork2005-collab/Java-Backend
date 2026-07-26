package opps;

/********** to invoke parent class variables ***********************/
//***************** to invoke method of parent class and constructor as well **************** */
class Animal{

    public Animal() {
        System.out.println("Parent constructor");
    }
    
    String color="whilte";
    void eat(){
        System.out.println("Animal is eating");
    }
}

class dog extends Animal{

    public dog() {
        super(); //to invoke parent class constructor;
    }
    
    String color="Black";
    void printColor(){
        System.out.println(color);
        System.out.println(super.color);
    }

    void eat(){ System.out.println("Dog is eating");}
    void bark(){System.out.println("Barking");}

    void work(){
        super.eat();
        bark();
        eat();
    }
}
 

public class superKeyword2 {
    public static void main(String[] args) {
        dog d1=new dog();
        d1.printColor();
        d1.work();
    }
}
