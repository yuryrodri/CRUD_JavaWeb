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
		frmCadastro.Nm_Cadastro.focus()
		return false
	}
	else if(fone.length < 14)
	{
		alert('Por favor, preencha o campo Fone corretamente')
		frmCadastro.Nr_Telefone.focus()
		return false
	}
	else
	{
		document.forms["frmCadastro"].submit();
	}
}