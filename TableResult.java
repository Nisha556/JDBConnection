






import java.sql.*;

public class TableResult {
   public static void main(String[] args) {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
      
      System.out.println("trying to connect");
         Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student","root", "nisha123#");
         //jdbc:mysql://localhost:3306/testdb?useSSL=false
         System.out.println("database connection created");
         
         Statement stmt = con.createStatement();
         ResultSet  rs = stmt.executeQuery("SELECT * FROM mylastday");
         System.out.println("roll  name    class   sub   address");
         
         while (rs.next()) {
            int roll = rs.getInt("roll");
            String name = rs.getString("name");
            String clas = rs.getString("class");
            String sub = rs.getString("sub");
            String address = rs.getString("address");
            System.out.println(roll+"   "+name+"    "+clas+"   "+sub+"   "+address);
         }
      } 
         catch(Exception e) {
         System.out.println("SQL exception occured" + e);
      }
   }
}