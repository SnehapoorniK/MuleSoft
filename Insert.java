    import java.sql.Connection;  
    import java.sql.DriverManager;  
    import java.sql.PreparedStatement;  
    import java.sql.SQLException;  
       
    public class Insert {  
       
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
       
      
        public void insert(String name, String actor, String actress, String director, double year) {  
            String sql = "INSERT INTO movies VALUES(?,?,?,?,?)";  
       
            try{  
                Connection conn = this.connect();  
                PreparedStatement pstmt = conn.prepareStatement(sql);  
                pstmt.setString(1, name); 
                pstmt.setString(2, actor); 
                pstmt.setString(3, actress); 
                pstmt.setString(4, director); 
                pstmt.setDouble(5, year);  
                pstmt.executeUpdate();  
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
        }  
       
        public static void main(String[] args) {  
       
            Insert app = new Insert();  
            app.insert("Titanic","Leonardo DiCaprio","Kate Winslet","James Cameron", 1997");  
            app.insert("Tenet","John David","Elizabeth" ,"Nolan",2020);  
            app.insert("The imitation game", "Benedict","Kelra","Morten",2014);  
        }  
       
    }  
