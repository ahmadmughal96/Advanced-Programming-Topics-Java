import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;


public class Configuration 
{	
	String url,username,password;
	Properties configuration = new Properties();
	InputStream file = null;
	public Configuration() throws SQLException
	{
		try
		{
			String filename = "config.properties";
			file = new FileInputStream(filename);
			configuration.load(file);
			
			url = configuration.getProperty("url");
			username = configuration.getProperty("username");
			password = configuration.getProperty("password");
			
			DBConnector connect = new DBConnector(url,username,password);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public String getURL()
	{
		return url;
	}
	public String getUsername()
	{
		return username;
	}
	public String Password()
	{
		return password;
	}
	
}
