<%@page import="model.JavaBeans"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	ArrayList<JavaBeans> listaClientes = (ArrayList<JavaBeans>) request.getAttribute("listaClientes");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="style.css">
<title>Relatório de Clientes</title>
</head>
<body>
	<h1>Relatório de Clientes</h1>
	<a href="novoCliente.html" class="btnPadrao">Novo Cliente</a>
	<table id="TB_Clientes">
		<thead>
			<tr>
				<th>ID_Cadastro</th>
				<th>Nm_Cadastro</th>
				<th>Nr_Telefone</th>
				<th>Dt_Cadastro</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
		<%for (int i = 0; i < listaClientes.size(); i++)
		{%>			
			<tr>
				<td><%=listaClientes.get(i).getID_Cliente()%></td>
				<td><%=listaClientes.get(i).getNm_Cliente()%></td>
				<td><%=listaClientes.get(i).getNr_Telefone()%></td>
				<td><%=listaClientes.get(i).getDt_Cadastro()%></td>
				<td>
					<a href="update" class="btnPadrao">Editar</a>
					<a href="" class="btnPadrao" style="background-color: red">Excluir</a>
				</td>
			</tr>
		<%}%>
		</tbody>	
	</table>
</body>
</html>