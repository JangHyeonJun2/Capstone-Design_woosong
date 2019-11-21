import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {
    public static Connection connect(String dbUrl, String dbId, String dbPassword)
        throws RuntimeException {

        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(dbUrl,dbId,dbPassword);


        }catch (Exception ex) {
            throw new RuntimeException();
        }
        return conn;
    } // connect


    // insert, update, delete ���ÿ� �� close() ���.
    // select �� ResultSet �� �ʿ��ϱ� ������. �ٸ� close() ���.
    public static void close(Connection conn, PreparedStatement ps) {
        if(ps != null) {
            try {
                ps.close();
            }catch(SQLException e) {
            }
        }

        if(conn != null) {
            try {
                conn.close();
            }catch (SQLException e) {

            }
        }

    } // close


    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            }catch(SQLException e) {}
        }
        close(conn,ps);
    }


}