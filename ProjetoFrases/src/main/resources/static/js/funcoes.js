function limparCampos(){
	
	var divMensagem = document.getElementById('divMensagem');
	if(divMensagem != null){
		divMensagem.style.display='none';
	}
	
	document.getElementById('tabela').style.display='none';
	var elementos = document.getElementsByTagName('input');
	for(var i = 0; i < elementos.length; i++){
		elementos[i].value = '';
	}
}