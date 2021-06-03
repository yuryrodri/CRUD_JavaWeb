package model;

public class JavaBeans
{
	public JavaBeans() 
	{
		super();
	}
	
	public JavaBeans(String iD_Cliente, String nm_Cliente, String nr_Telefone) {
		super();
		this.ID_Cliente = iD_Cliente;
		this.Nm_Cliente = nm_Cliente;
		this.Nr_Telefone = nr_Telefone;
	}

	private String ID_Cliente;
	private String Nm_Cliente;
	private String Nr_Telefone;

	public String getID_Cliente()
	{
		return ID_Cliente;
	}
	public String getNm_Cliente()
	{
		return Nm_Cliente;
	}
	public void setNm_Cliente(String nm_Cliente) 
	{
		Nm_Cliente = nm_Cliente;
	}
	public String getNr_Telefone()
	{
		return Nr_Telefone;
	}
	public void setNr_Telefone(String nr_Telefone) 
	{
		Nr_Telefone = nr_Telefone;
	}

}
