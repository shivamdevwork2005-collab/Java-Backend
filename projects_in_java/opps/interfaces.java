package opps;

//interface can enforce a contract - that is provide a specification that classes must impliment  certain methods if they want to use that intrface.
//used to achive multiple inheritance
// we can achive loose coupling :-changes is one class do  not affect the other class;

interface PizzaRecipie{
    public abstract  void makeDough(); //defout public abstract void.
    public void proofDough();
    public void prepare_souce_and_toppings();
    public void shapeDough();
    public void bakePizza();
}

class chef1 implements PizzaRecipie{

    public chef1() { 
    }
    
    public void makeDough(){
        System.out.println("makeDouhg");
    }
    public void proofDough(){
        System.out.println("proofDough");
    }
    public void prepare_souce_and_toppings(){
        System.out.println("Make topping's");
    }
    public void shapeDough(){
        System.out.println("shapeDough");
    }
    public void bakePizza(){
        System.out.println("Bake pizza");
    }
}


public class interfaces {
    public static void main(String[] args) {
        chef1 c1=new chef1();
        c1.bakePizza();

        PizzaRecipie r1=new chef1(); // this is also how we create obj bec obj is always of a class.
        PizzaRecipie r2=new chef1();

        r1.prepare_souce_and_toppings();
        r2.makeDough();

    }
}
