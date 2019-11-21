import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParkingLot {
	private String dbUrl;
	private String dbId;
	private String password;
	
	public ParkingLot() {
		this.dbUrl = "jdbc:mysql://13.209.77.137:57674/arduino?serverTimezone=Asia/Seoul&useSSL=false";
    	this.dbId = "root";
    	this.password = "1234";
	}
	public void addParkingLot(String number) {
		Connection conn = DbUtil.connect(dbUrl, dbId, password);
		String sql = "INSERT INTO arduino.parking_lot(pNumber)VALUES(?)";
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, number);
			ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
//			DbUtil.close(conn, ps);
		}
	}

}
