import java.sql.*;
import java.util.Scanner;

public class BatchProcessing2 {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Shivam@2005";


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
            con.setAutoCommit(false);
            String query="INSERT INTO employees(id,name,job_title,salary) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            Scanner sc=new Scanner(System.in);
            while(true){
                System.out.print("Enter id:-");
                int id=sc.nextInt();
                sc.nextLine();
                System.out.print("Enter name:-");
                String name=sc.nextLine();
                System.out.print("Enter job title:-");
                String job_title=sc.nextLine();
                System.out.print("Enter salary:-");
                double salary=sc.nextDouble();
                sc.nextLine();

                preparedStatement.setInt(1,id);
                preparedStatement.setString(2,name);
                preparedStatement.setString(3,job_title);
                preparedStatement.setDouble(4,salary);
                preparedStatement.addBatch();
                System.out.print("Add more values Y/N:-");
                String decision=sc.nextLine();
                if(decision.toUpperCase().equals("N")){
                    break;
                }
            }
            int[]batchRes=preparedStatement.executeBatch();
            con.commit();
            System.out.println("Batch executed successfully.");

            con.close();
            preparedStatement.close();
            System.out.println("Connection closed successfully !!!!!!!!!!.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

