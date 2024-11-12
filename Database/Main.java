import java.sql.DriverManager;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
       try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "root");
        System.out.println(con);
    }
    catch (Exception e){
       }
    }
}