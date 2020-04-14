import java.awt.Color;
import java.awt.FlowLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;



public class Interface
{
	static String count1, count2;
	{
		Properties properties = new Properties();
		InputStream input = null;
		
		try
		{
				input = new FileInputStream("config.properties");
		
				properties.load(input);
				System.out.println(properties.getProperty("noOfItems"));
				count1 = properties.getProperty("noOfItems");
				count2 = properties.getProperty("FlashTime");
				Function(count1);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if (input != null) 
			{
				try 
				{
					input.close();
				} catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}

	}

	public static void Function(String count)
	{
		JFrame frame = new JFrame("Flow Layout");
		JButton button;
		
		int number = Integer.parseInt(count); 
		int color = 4;
		
		for(int i = 0; i < number; i++)
		{
			button = new JButton("a");
			frame.add(button);
			color = color + 10;
			button.setBackground(new Color(color, 150, 150));
		}
		
		frame.setLayout(new FlowLayout());
		frame.setSize(500,500);  
		frame.setVisible(true);  
	}
}