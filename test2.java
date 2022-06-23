import java.sql.*;
import java.sql.SQLException;

public class test2 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost; database=movie_reserv; user=sa; password=Ghksgml3517!; encrypt=true; trustServerCertificate=true";
            Connection conn = DriverManager.getConnection(connectionUrl);
            Statement stmt = conn.createStatement();
            ResultSet rs2 = stmt.executeQuery("select Rv_content,count(Like_) as GOOD, count(DisLike_) as BAD\n"
            		+ "from review,reaction,movie\n"
            		+ "where review.movie_num = movie.movie_num and reaction.review_num = review.review_num\n"
            		+ "GROUP by Rv_content");
            while(rs2.next() )
            {
            	String field11 = rs2.getString(1);
            	String field22 = rs2.getString(2);
            	String field33 = rs2.getString(3);
            	System.out.print(field11 + "\t");
                System.out.print(field22 +" GOOD"+ "\t");
                System.out.println(field33+" BAD");
            }
            rs2.close();
            stmt.close();   
            conn.close();
        } catch (ClassNotFoundException sqle) {
        	System.out.println("SQLException : " + sqle);
        }
   }
}

