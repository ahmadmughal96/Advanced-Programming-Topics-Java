
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	private Properties prop;
	private InputStream input;
	
	public Configuration(){
		prop = new Properties();
		
		try {
			input = new FileInputStream("properties.config");
			
			prop.load(input);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getUrl() {
		return prop.getProperty("url");
	}
	
	public String getUsername() {
		return prop.getProperty("username");
	}
	
	public String getPassword() {
		return prop.getProperty("password");
	}
}

