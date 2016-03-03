package com.ProjetoFrases.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProjetoFrases.model.Frase;

public interface FraseRepository extends JpaRepository<Frase, Integer> {
	
	public List<Frase> findByTituloFraseContainingAndAutorFraseContaining(String titulo,String autor);

}
