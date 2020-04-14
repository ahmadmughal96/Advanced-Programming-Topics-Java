//Ahmad Amjad Mughal
import java.sql.Connection;
//121672
//BSCS-6C
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private Configuration config = null; //setting configuration reference to null
	
	public DBConnector() {
		config = new Configuration(); //creating instance of Configuration
	}
	
	public Connection getConnect() {  //required parameters are passed from configuration class via get Methods
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}
