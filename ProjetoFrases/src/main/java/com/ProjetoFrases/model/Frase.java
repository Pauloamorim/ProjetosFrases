package com.ProjetoFrases.model;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tb_frases", schema="Frases")
public class Frase {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_frase")
	private Integer codigo;
	
	@Column(name="titulo_frase")
	private String tituloFrase;
	
	@Column(name="descricao_frase")
	private String descricaoFrase;
	
	@Column(name="autor_frase")
	private String autorFrase;
	
	@Column(name="categoria_frase")
	private String categoriaFrase;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricaoFrase() {
		return descricaoFrase;
	}

	public void setDescricaoFrase(String descricaoFrase) {
		this.descricaoFrase = descricaoFrase;
	}

	public String getAutorFrase() {
		return autorFrase;
	}

	public void setAutorFrase(String autorFrase) {
		this.autorFrase = autorFrase;
	}

	public String getCategoriaFrase() {
		return categoriaFrase;
	}

	public void setCategoriaFrase(String categoriaFrase) {
		this.categoriaFrase = categoriaFrase;
	}

	public String getTituloFrase() {
		return tituloFrase;
	}

	public void setTituloFrase(String tituloFrase) {
		this.tituloFrase = tituloFrase;
	}
	
	

}
