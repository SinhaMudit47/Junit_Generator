import java.sql.*;

class ConnectionJDBC {
    public static void main(String[] args) throws Exception
    {
        String url
                = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";
        String query
                = "select * from CALENDAR"; //
        Class.forName(
                "com.mysql.cj.jdbc.Driver"); // Driver name
        Connection con = DriverManager.getConnection(
                url, username, password);
        System.out.println(
                "Connection Established successfully");
        Statement st = con.createStatement();
        ResultSet rs
                = st.executeQuery(query); // Execute query
        rs.next();
        String name
                = rs.getString("MONTHS");

        System.out.println(name);
        st.close();
        con.close();
        System.out.println("Connection Closed....");
    }
}