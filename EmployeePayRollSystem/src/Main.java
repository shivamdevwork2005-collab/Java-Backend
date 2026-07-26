import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }

     public String getName() {
         return name;
     }

     public int getId() {
         return id;
     }

     public abstract double calcSalary(); //abstract method

     @Override
     public String toString(){
         return "Employee[name="+name+" ,id="+id+" ,salary="+calcSalary()+"]";
     }
 }



 class fullTimeEmployee extends Employee{
    private double monthlySalary;

    public fullTimeEmployee(String name ,int id,double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }
    @Override
     public double calcSalary(){
        return monthlySalary;
    }
 }



 class partTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public partTimeEmployee(String name ,int id,int hoursWorked,double hourlyRate){
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }

    @Override
     public double calcSalary(){
        return hoursWorked * hourlyRate;
    }

 }



class payRoolSysytem{
    private ArrayList<Employee> employeeList;

    public payRoolSysytem(){

        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){

        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove=null;
        for(Employee employee:employeeList){
            if(employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
        }
        if(employeeToRemove!=null){
            System.out.println(employeeToRemove);
            employeeList.remove(employeeToRemove);
        }
    }


    public void displayEmployees(){
        for(Employee emp:employeeList){
            System.out.println(emp);
        }
    }


}



public class Main {
    public static void main(String[] args) {
        payRoolSysytem payRoolSysytem1=new payRoolSysytem();
        fullTimeEmployee emp1=new fullTimeEmployee("Vikas",2005,100000.0);
        partTimeEmployee emp2=new partTimeEmployee("Shivam",2003,20,100);
        payRoolSysytem1.addEmployee(emp1);
        payRoolSysytem1.addEmployee(emp2);
        System.out.println("Initial emp details:- ");
        payRoolSysytem1.displayEmployees();
        System.out.println("Removing employees:- ");
        payRoolSysytem1.removeEmployee(2003);
        System.out.println("Remianing emp details:- ");
        payRoolSysytem1.displayEmployees();
    }
}