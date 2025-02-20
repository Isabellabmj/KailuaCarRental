package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDatabase
{
   private static final String DB_URL = "jdbc:mysql://localhost:3306/kailuacarrental";
   private static final String USER = "root";
   private static final String PASSWORD = "Onsdagmorgen11!!"; //finde en måde at gøre kode usynlig


       public static Connection getConnection() throws SQLException
       {
           return DriverManager.getConnection(DB_URL, USER, PASSWORD);
       }



//       try
//       {
//           Class.forName("com.mysql.cj.jdbc.Driver");
//
//           Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//           System.out.println("Connected to database");
//
//           Statement stmt = con.createStatement();
//           ResultSet rs = stmt.executeQuery("Show tables");
//
//           System.out.println("List of tables:");
//           while (rs.next())
//           {
//               System.out.println(" - " + rs.getString(1));
//           }
//
//           con.close();
//           stmt.close();
//           rs.close();
//           System.out.println("Connection closed");
//       }
//       catch(SQLException e)
//       {
//           System.out.println("Error in database connection" + e.getMessage());
//       }
//       catch(ClassNotFoundException e)
//       {
//           System.out.println("JDBC driver not found" + e.getMessage());
//       }

}
