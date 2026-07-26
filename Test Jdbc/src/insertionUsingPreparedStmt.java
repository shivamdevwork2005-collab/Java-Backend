import java.sql.*;
import java.util.Scanner;

public class insertionUsingPreparedStmt {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Shivam@2005";
        //prepared stmt
        String querry = "insert into employees(id,name,job_title,salary) VALUES(? , ? , ? , ?)"; //placeholder;

        //loaded the driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //now building the connections;
        try{
            Connection con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection build successfully");

            Scanner sc=new Scanner(System.in);
            System.out.print("Enter id:-");
            int id=sc.nextInt();
            sc.nextLine();
            System.out.print("Enter name:-");
            String name=sc.nextLine();
            System.out.print("Enter job title:-");
            String job_title=sc.nextLine();
            System.out.print("Enter the slalary:-");
            Double salary=sc.nextDouble();

//          Statement statement=connection.createStatement();
            PreparedStatement preparedStatement = con.prepareStatement(querry); //prepared statement with placeholder.
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,job_title);
            preparedStatement.setDouble(4,salary);

            int rowsAffected=preparedStatement.executeUpdate();
            if(rowsAffected>0){
                System.out.println("Data inserted successfully");
            }
            else{
                System.out.println("Data Insertion Failed");
            }

            preparedStatement.close();
            con.close();
            System.out.println();
            System.out.println("Connection closed successfully !!!!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
