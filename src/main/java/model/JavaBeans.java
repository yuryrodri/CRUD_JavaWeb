package model;

public class JavaBeans
{
	public JavaBeans()
	{
		super();
	}

	public JavaBeans(String iD_Cliente, String nm_Cliente, String nr_Telefone, String dt_Cadastro)
	{
		super();
		this.ID_Cliente = iD_Cliente;
		this.Nm_Cliente = nm_Cliente;
		this.Nr_Telefone = nr_Telefone;
		this.Dt_Cadastro = dt_Cadastro;
	}

	private String ID_Cliente;
	private String Nm_Cliente;
	private String Nr_Telefone;
	private String Dt_Cadastro;

	public String getDt_Cadastro()
	{
		return Dt_Cadastro;
	}

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
