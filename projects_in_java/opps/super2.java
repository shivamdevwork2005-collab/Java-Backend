package opps;

class parent {
    String color = "White";

    void printColor() {
        System.out.println("Parent color: " + color);
    }
}

class child extends parent {
    String color = "Black";

    void printColor() {
        System.out.println("Child color: " + color);
        System.out.println("Parent color: " + super.color);
    }
}

public class super2 {
    public static void main(String[] args) {
        child c = new child();
        c.printColor();
    }
}
