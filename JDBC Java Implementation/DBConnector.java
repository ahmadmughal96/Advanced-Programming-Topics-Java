import java.sql.*; 
public class DBConnector 
{
	String url;
	String username;
	String password;
	public DBConnector(){}
	public DBConnector(String url, String username, String password) throws SQLException
	{
		this.url = url;
		this.username = username;
		this.password = password;
		
		
	}
}
