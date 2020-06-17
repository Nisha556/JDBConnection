package myfirstproject;



import java.sql.*;

public class JDBCUpdateExample {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/student";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "nisha123#";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.cj.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql = "UPDATE mylastday " +
                   "SET sub = 'DBMS' WHERE roll in (100, 101)";
      stmt.executeUpdate(sql);

      // Now you can extract all the records
      // to see the updated records
      sql = "SELECT roll, name, class, sub, address FROM mylastday";
      ResultSet rs = stmt.executeQuery(sql);

      while(rs.next()){
         //Retrieve by column name
         int roll  = rs.getInt("roll");
         
         String name = rs.getString("name");
         String clas = rs.getString("class");
         String sub = rs.getString("sub");
         String address = rs.getString("address");

         //Display values
         System.out.print("roll: " + roll);
         System.out.print(", name: " + name);
         System.out.print(", class: " + clas);
         System.out.println(", sub: " + sub);
         System.out.println(", address: " + address);
      }
      rs.close();
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample