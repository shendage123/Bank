package Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Genral  {
	public static Connection getConnect() throws SQLException 
	{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","root");
	}

	
}
