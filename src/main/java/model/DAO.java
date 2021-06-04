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
			return con;
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
	}

	public ArrayList<JavaBeans> listarClientes()
	{
		ArrayList<JavaBeans> listaClientes = new ArrayList<JavaBeans>();
		try
		{
			Connection con = conectar();
			String instrucaoSQL = "select * from TB_Clientes order by Nm_Cliente";
			PreparedStatement stmt = con.prepareStatement(instrucaoSQL);
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next())
			{
				JavaBeans cliente = new JavaBeans
						(
							resultSet.getString("ID_Cliente"),
							resultSet.getString("Nm_Cliente"),
							resultSet.getString("Nr_Telefone"),
							resultSet.getString("Dt_Cadastro")
						);
				listaClientes.add(cliente);
			}
			
			return listaClientes;
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
					+ "(Nm_Cliente,Nr_Telefone,Dt_Cadastro)"
					+ "values (?,?,GETDATE())";
			PreparedStatement stmt = con.prepareStatement(instrucaoSQL);
			stmt.setString(1, cliente.getNm_Cliente());
			stmt.setString(2, cliente.getNr_Telefone());
			stmt.execute();
			con.close();
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}

	}
	
	public JavaBeans pesquisarCliente(String ID_Cliente)
	{
		JavaBeans cliente = new JavaBeans();
		try
		{
			Connection con = conectar();
			String intrucaoSQL = "Select * from TB_Clientes where ID_Cliente = ?";
			PreparedStatement stmt = con.prepareStatement(intrucaoSQL);
			stmt.setInt(1, Integer.parseInt(ID_Cliente));
			ResultSet resultSet = stmt.executeQuery();
			resultSet.next();
			cliente.setIDCliente(resultSet.getString("ID_Cliente"));
			cliente.setNm_Cliente(resultSet.getString("Nm_Cliente"));
			cliente.setNr_Telefone(resultSet.getString("Nr_Telefone"));
			con.close();
			
			return cliente;
		}
		catch (Exception e)
		{
			System.out.println(e);
			return null;
		}		
	}
	
	public void editarCliente(JavaBeans cliente)
	{
		try
		{
			Connection con = conectar();
			String instrucaoSQL = "Update TB_Clientes "
					+ "Set Nm_Cliente = ? , Nr_Telefone = ? "
					+ "Where ID_Cliente = ?";
			PreparedStatement stmt = con.prepareStatement(instrucaoSQL);
			stmt.setString(1, cliente.getNm_Cliente());
			stmt.setString(2, cliente.getNr_Telefone());
			stmt.setInt(3, Integer.parseInt(cliente.getID_Cliente()));
			stmt.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void excluirCliente(String ID_Cliente)
	{
		try
		{
			Connection con = conectar();
			String instrucaoSQL = "Delete from TB_Clientes Where ID_Cliente = ?";
			PreparedStatement stmt = con.prepareStatement(instrucaoSQL);
			stmt.setInt(1, Integer.parseInt(ID_Cliente));
			stmt.execute();
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
