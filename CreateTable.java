    import java.sql.Connection;  
    import java.sql.DriverManager;  
    import java.sql.SQLException;  
    import java.sql.Statement;  
     //Movie Table  
    public class CreateTable {  
       
        public static void createNewTable() {  
            // SQLite connection string  
            String url = "jdbc:sqlite:C://sqlite/SSSIT.db";  
              
            // SQL statement for creating a new table  
            String sql = "CREATE TABLE movies (\n"  
                        + " name char(20),\n"  
                        + " actor char(20),\n"  
                        + " actress char(20),\n"  
                        + " director char(20),\n" 
                        + " year int\n" 
                        + ");";  
              
            try{  
                Connection conn = DriverManager.getConnection(url);  
                Statement stmt = conn.createStatement();  
                stmt.execute(sql);  
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
        }   
        public static void main(String[] args) {  
            createNewTable();  
        }  
       
    } 
