package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
			System.out.println("Conectou");
			return con;
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	public void cadastrar(JavaBeans cliente)
	{
		try
		{
			Connection con = conectar();
			String instrucaoSQL = "insert into TB_Clientes"
					+ "(Nm_Cliente,Nr_Telefone)"
					+ "values (?,?,GETDATE())";
			PreparedStatement stmt = con.prepareStatement(instrucaoSQL);
			stmt.setString(1, cliente.getNm_Cliente());
			stmt.setString(2, cliente.getNr_Telefone());
			stmt.execute();
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}

	}
	
	public ArrayList<JavaBeans> buscarClientes()
	{
		try
		{
			Connection con = conectar();
			String instrucaoSQL = "select * from TB_Clientes";
			PreparedStatement stmt = con.prepareStatement(instrucaoSQL);
			ResultSet resultSet = stmt.executeQuery();
			return null;
		}
		catch (Exception e)
		{
			return null;
		}
		
	}
}
