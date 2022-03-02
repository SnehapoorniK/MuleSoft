import java.sql.DriverManager;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
   
public class Select {  
   
    private Connection connect() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:C://sqlite/SSSIT.db";  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }  
   
  
    public void selectAll(){  
        String sql = "SELECT * FROM movies" ;  
          
        try {  
            Connection conn = this.connect();  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) {  
                System.out.println(rs.getString("name") + "\t" +  
                                   rs.getString("actor") + "\t" +  
                                   rs.getString("actress") + "\t" +  
                                   rs.getString("director") + "\t" +  
                                   rs.getDouble("year"));  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
    }   
    public static void main(String[] args) {  
        Select app = new Select();  
        app.selectAll();  
    }  
   
}
