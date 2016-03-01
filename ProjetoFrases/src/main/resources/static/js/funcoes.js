function limparCampos(){
	var elementos = document.getElementsByTagName('input');
	for(var i = 0; i < elementos.length; i++){
		elementos[i].value = '';
	}
}