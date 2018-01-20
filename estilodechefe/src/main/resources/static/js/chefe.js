//Ação será ativada quando mostrar o modal
$('#confirmarExcluirModal').on('show.bs.modal',function(event){
	
	//Qual botão desparou o evento (variavel do tipo jquery)
	var button = $(event.relatedTarget);
	
	//recupera os atributos do tipo data do codigo do botao
	var codigoUsuario = button.data('codigo');
	
	var nomeUsuario = button.data('nome');
	
	var sobrenomeUsuario = button.data('sobrenome');
	
	//para mapear o modal do codigo do usuario
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	
	if(!action.endsWith('/')){
		action += '/';
		
	}
	
	form.attr('action', action + codigoUsuario);
	
	modal.find('.modal-body span').html('Deseja remover o Usuário <strong>' + nomeUsuario + '   <strong>' + sobrenomeUsuario + '</strong>?');
	
	
	});


//quando a pagina acabar de carregar vai executar essa função
//vai procurar os componentes do tooltip e chama-lo pelo .tooltip
$(function(){
	$('[rel="tooltip"]').tooltip();

 });




