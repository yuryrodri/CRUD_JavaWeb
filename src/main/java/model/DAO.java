package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO
{
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=CRUD_JavaWeb";
	private String user = "sa";
	private String pass = "unip";
	
	private Connection conectar()
	{
		Connection con = null;
		try 
		{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
			return con;
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return null;
		}
	}
	
}
