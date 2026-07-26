import java.io.*;
import java.sql.*;

public class retriveImage {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/mydatabase";
        String username="root";
        String password="Shivam@2005";
        String folderPath="C:\\Users\\ganes\\Desktop\\weding\\";

        String querry = "SELECT image_data from image_table where image_id = (?)"; //PREPARED STMT.

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

            PreparedStatement preparedStatement=con.prepareStatement(querry);
            preparedStatement.setInt(1,1);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                byte[] image_data=resultSet.getBytes("image_data");
                String image_path=folderPath+"extracted_image.jpg";
                OutputStream outputStream=new FileOutputStream(image_path);
                outputStream.write(image_data);
                System.out.println("Image found and process done.");
            }
            else{
                System.out.println("Image not found !!!.");
            }


            con.close();
            System.out.println("Connection closed !!!.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
