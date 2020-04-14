import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Country 
{
	private File file = null;
	DBHandler handler = new DBHandler();
	
	public Country() throws IOException
	{
		file = new File("C:\\Users\\Ahmad Amjad Mughal\\Desktop\\GeoLiteCity-Location.csv");
		int counter = 0;
		BufferedReader reader = new BufferedReader(new FileReader(file));
		List<String> lines = new ArrayList<String>();
		String line = null;
		while ((line = reader.readLine()) != null) {
		    lines.add(line);
		    handler.save(line);
		    
		    counter++;
		    
		    if (counter > 4000)
		    {
		    	break;
		    }
		}

	}
}
