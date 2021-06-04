<%@page import="model.JavaBeans"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
JavaBeans cliente = (JavaBeans) request.getAttribute("cliente");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="style.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
<title>Editar Cliente</title>
</head>
<body>
	<h1>Editar Cliente</h1>
	<form name="frmCliente" action="update">
		<table>
			<tr>
				<td><label>ID_Cliente</label></td>
			</tr>
			<tr>
				<td><input type="text" readonly="readonly" name="ID_Cliente"
					value="<%=cliente.getID_Cliente()%>" class="cxTexto"
					style="width: 30px"></td>
			</tr>
			<tr>
				<td><label>Nm_Cliente</label></td>
			</tr>
			<tr>
				<td><input type="text" name="Nm_Cliente"
					value="<%=cliente.getNm_Cliente()%>" class="cxTexto"></td>
			</tr>
			<tr>
				<td><label>Nr_Telefone</label></td>
			</tr>
			<tr>
				<td><input type="text" name="Nr_Telefone"
					value="<%=cliente.getNr_Telefone()%>"
					onkeypress="$(this).mask('(00) 0000-00009')" class="cxTexto"></td>
			</tr>
		</table>
		<input type="button" value="Editar Cliente" class="btnPadrao"
			onclick="validar()">
	</form>
	<script src="scripts/validar.js" type="text/javascript"></script>
</body>
</html>