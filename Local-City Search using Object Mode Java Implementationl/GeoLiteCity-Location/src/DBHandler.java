//Ahmad Amjad Mughal
//121672
//BSCS-6C
import java.sql.*;

public class DBHandler {
	 DBConnector con = null;
	 Connection myconnection = null;
	
	public DBHandler() //constructor for setting connection 
	{
		con = new DBConnector();  //connecting DBHandler to DBConnector
		myconnection = con.getConnect(); //create connection
	}
	
	public void save(String list) //save function that takes Person instance and map each attributes to column of table 
	{
		System.out.println(list);
		String[] splitter = list.split(",");
		String column1 = splitter[0];
		String column2 = splitter[1];
		String column3 = splitter[2];
		String column4 = splitter[3];
		String column5 = splitter[4];
		String column6 = splitter[5];
		String column7 = splitter[6];
		String column8 = splitter[7];
		String column9 = splitter[8];
		
		String sql = " Insert into country (id, country, region, city, postalCode, latitude, longitude, metroCode, areaCode)"
				+ "values ("+ column1 +",'"+column2+"','"+column3+"','"+column4+"','"+column5+"','"+column6+"','"+column7+"','"+column8+"','"+column9+"');";
		try 
		{	
			Statement stmt = myconnection.createStatement(); //creating statement
			stmt.executeUpdate(sql);
				
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void get(int id) { //for getting info of specific record and to display it on console
		String sql = " Select * from person where id ="+id+";";
		
		try {
			Statement stmt = myconnection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
		         //Getting data by specifying each column name 
				 id = rs.getInt("id");
		         String country = rs.getString("country");
		         String region = rs.getString("region");
		         String city = rs.getString("city");
		         String postalCode = rs.getString("postalCode");
		         double latitute = rs.getDouble("latitute");
		         double longitute = rs.getDouble("longitude");
		         String metroCode = rs.getString("metroCode");
		         String areaCode = rs.getString("areaCode");

		         //Displaying the resultant Record
		         System.out.println("ID: " + id);
		         System.out.println("Country: " + country);
		         System.out.println("Region: " + region);
		         System.out.println("City: " + city);
		         System.out.println("PostalCode: " + postalCode);
		         System.out.println("Latitute: " + latitute);
		         System.out.println("Longitute: " + longitute);
		         System.out.println("MetroCode: " + metroCode);
		         System.out.println("AreaCode: " + areaCode);
		      }
		      rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
	