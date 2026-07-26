package opps;

class student1{
    int age;
    int id;

    public student1(int age,int id) {
        this.age=age;
        this.id=id;
    }

    public void display(){
        System.out.println("age"+"->"+age+" "+"id"+"->"+id);
    }
    
}

public class constructor {
    public static void main(String[] args) {
        student1 s1=new student1(28, 2220837);
        s1.display();
    }
}
