package opps;

class student{
    String name;
    int age;
    int roll_no;

    void print(){
        System.out.println(name);
        System.out.println(age);
        System.out.println(roll_no);
    }
}

public class AccesSpecifier {
    public static void main(String[] args) {
        student s1=new student();
        s1.age=90;
        s1.print();
    }
}












