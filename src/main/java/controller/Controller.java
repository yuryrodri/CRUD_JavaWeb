package controller;

import java.io.IOException;
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
@WebServlet(urlPatterns = {"/Controller", "/main" , "/insert"})
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
		if(action.equals("/main"))
		{
			response.sendRedirect("clientes.jsp");			
		}
		else if(action.equals("/insert"))
		{
			cliente.setNm_Cliente(request.getParameter("Nm_Cliente"));
			cliente.setNr_Telefone(request.getParameter("Nr_Telefone"));
			dao.cadastrar(cliente);
			response.sendRedirect("main");
		}
		else
		{
			response.sendRedirect("main");
		}
	}

}
