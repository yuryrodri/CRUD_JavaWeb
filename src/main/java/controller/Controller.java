package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/buscar", "/update", "/delete" })
public class Controller extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();
	JavaBeans cliente = new JavaBeans();

	public Controller()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getServletPath();
		if (action.equals("/main"))
		{
			carregarClientes(request, response);
		}
		else if (action.equals("/insert"))
		{
			cadastrarCliente(request, response);
		}
		else if (action.equals("/buscar"))
		{
			pesquisarCliente(request, response);
		}
		else if (action.equals("/update"))
		{
			editarCliente(request, response);
		}
		else if (action.equals("/delete"))
		{
			excluirCliente(request, response);
		}
		else
		{
			response.sendRedirect("main");
		}
	}

	protected void carregarClientes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		ArrayList<JavaBeans> listaClientes = dao.listarClientes();
		request.setAttribute("listaClientes", listaClientes);
		RequestDispatcher rd = request.getRequestDispatcher("clientes.jsp");
		rd.forward(request, response);
	}

	protected void cadastrarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		cliente = new JavaBeans();
		cliente.setNm_Cliente(request.getParameter("Nm_Cliente"));
		cliente.setNr_Telefone(request.getParameter("Nr_Telefone"));
		dao.cadastrar(cliente);
		response.sendRedirect("main");
	}

	protected void pesquisarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String ID_Cliente = request.getParameter("ID_Cliente");
		cliente = dao.pesquisarCliente(ID_Cliente);
		request.setAttribute("cliente", cliente);
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	protected void editarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		cliente = new JavaBeans();
		cliente.setIDCliente(request.getParameter("ID_Cliente"));
		cliente.setNm_Cliente(request.getParameter("Nm_Cliente"));
		cliente.setNr_Telefone(request.getParameter("Nr_Telefone"));
		dao.editarCliente(cliente);
		response.sendRedirect("main");
	}

	protected void excluirCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String ID_Cliente = request.getParameter("ID_Cliente");
		dao.excluirCliente(ID_Cliente);
		response.sendRedirect("main");
	}
}
