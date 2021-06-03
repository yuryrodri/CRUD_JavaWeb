/**
 * Validação de Formulário
 */

function validar()
{
	let nome = frmCliente.Nm_Cliente.value
	let fone = frmCliente.Nr_Telefone.value
	if(nome == "")
	{
		alert('Por favor, preencha o campo Nome')
		frmCliente.Nm_Cliente.focus()
		return false
	}
	else if(nome.length > 50)
	{
		alert('O campo Nome não pode ter mais de 50 caracteres')
		frmCliente.Nm_Cliente.focus()
		return false
	}
	else if(fone.length < 14)
	{
		alert('Por favor, preencha o campo Fone corretamente')
		frmCliente.Nr_Telefone.focus()
		return false
	}
	else
	{
		document.forms["frmCliente"].submit();
	}
}