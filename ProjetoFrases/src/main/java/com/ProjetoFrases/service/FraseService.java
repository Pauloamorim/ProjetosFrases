package com.ProjetoFrases.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoFrases.filter.FrasesFiltro;
import com.ProjetoFrases.model.Frase;
import com.ProjetoFrases.repository.FraseRepository;

@Service
public class FraseService {

	@Autowired
	private FraseRepository fraseRepository;
	
	
	public void salvar(Frase frase){
		fraseRepository.save(frase);
	}


	public List<Frase> pesquisar(FrasesFiltro filtro) {
		return fraseRepository.findByTituloFraseContainingAndAutorFraseContaining(filtro.getTituloFrase(), filtro.getAutorFrase());
	}


	public Frase obter(Integer codigo) {
		return fraseRepository.findOne(codigo);
	}


	public void excluir(Integer codigo) {
		fraseRepository.delete(codigo);
	}
	
}
