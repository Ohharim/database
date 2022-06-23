import java.sql.*;
import java.sql.SQLException;

public class test1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost; database=movie_reserv; user=sa; password=Ghksgml3517!; encrypt=true; trustServerCertificate=true";
            Connection conn = DriverManager.getConnection(connectionUrl);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select member.member_id,name,cinema.Theater_num,cinema.[location],cinema.seat_num,title,cinema.Time\n"
            		+ "from member,cinema,show,movie\n"
            		+ "where member.member_id = cinema.member_id and show.movie_num = movie.movie_num");
          
            
            while( rs.next() ) 
            {
                   String field1 = rs.getString(1);
                   String field2 = rs.getString(2);
                   String field3 = rs.getString(3);
                   String field4 = rs.getString(4);
                   String field5 = rs.getString(5);
                   String field6 = rs.getString(6);
                   String field7 = rs.getString(7);
                   System.out.print(field1 + "\t");
                   System.out.print(field2 + "\t");
                   System.out.print(field3 + "\t");
                   System.out.print(field4 + "\t");
                   System.out.print(field5 + "\t");
                   System.out.print(field6 + "\t");
                   System.out.println(field7 );
            }
           
           
            rs.close();
           
            stmt.close();   
            conn.close();
        } catch (ClassNotFoundException sqle) {
        	System.out.println("SQLException : " + sqle);
        }
   }
}