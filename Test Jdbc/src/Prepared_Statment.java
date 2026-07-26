import java.net.ConnectException;
import java.sql.*;

public class Prepared_Statment {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Shivam@2005";
        //prepared stmt
        String querry = "select * from employees where name = ? And job_title = ?"; //placeholder;

        //loaded the driver
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //now building the connections;
        try{
            Connection con=DriverManager.getConnection(url,username,password);
            System.out.println("Connection build successfully");
//          Statement statement=connection.createStatement();
            PreparedStatement preparedStatement = con.prepareStatement(querry); //prepared statement with placeholder.
            preparedStatement.setString(1,"Rahul");
            preparedStatement.setString(2,"Software developer");
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String job_title=resultSet.getString("job_title");
                double salary=resultSet.getDouble("salary");
                System.out.println("Id:- "+id);
                System.out.println("name:- "+name);
                System.out.println("Job_title:- "+job_title);
                System.out.println("Salary:- "+salary);
            }


            resultSet.close();
            preparedStatement.close();
            con.close();
            System.out.println();
            System.out.println("Connection closed successfully !!!!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
