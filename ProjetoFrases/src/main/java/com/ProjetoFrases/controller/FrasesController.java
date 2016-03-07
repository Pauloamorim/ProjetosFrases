package com.ProjetoFrases.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ProjetoFrases.filter.FrasesFiltro;
import com.ProjetoFrases.model.Frase;
import com.ProjetoFrases.service.FraseService;

@Controller
@RequestMapping(value="/frases")
public class FrasesController {
	
	@Autowired
	private FraseService fraseService;

	private static final String TELA_PESQUISA = "/manterFrases/listFrases";
	private static final String TELA_MANTER = "/manterFrases/editFrases";
	
	
	@RequestMapping
	public ModelAndView init(){
		ModelAndView mv = new ModelAndView(TELA_PESQUISA);
		return mv;
	}
	
	@RequestMapping(value="/pesquisar",method=RequestMethod.GET)
	public ModelAndView pesquisar(FrasesFiltro filtro,RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView(TELA_PESQUISA);
		List<Frase> listaFrases = fraseService.pesquisar(filtro);
		
		if(listaFrases == null || listaFrases.isEmpty()){
			mv.addObject("mensagem", "Nenhum Registro encontrado.");
		}
		mv.addObject("listaFrases",listaFrases);
		return mv;
	}
	
	@RequestMapping("novo")
	public ModelAndView carregarInclusão(){
		ModelAndView mv = new ModelAndView(TELA_MANTER);
		mv.addObject("frase",new Frase());
		return mv;
	}
	@RequestMapping("{codigo}")
	public ModelAndView carregarAlterar(@PathVariable Integer codigo ){
		ModelAndView mv = new ModelAndView(TELA_MANTER);
		mv.addObject("frase",fraseService.obter(codigo));
		return mv;
	}
	
	@RequestMapping("excluir/{codigo}")
	public ModelAndView excluir(@PathVariable Integer codigo,RedirectAttributes attributes){
		ModelAndView mv = new ModelAndView(TELA_MANTER);
		fraseService.excluir(codigo);
		mv.addObject("mensagem", "Registro excluído com sucesso!");
		return pesquisar(new FrasesFiltro(), attributes);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String salvar(@Validated Frase frase,Errors errors,RedirectAttributes attributes){
		
		if(validarCamposObrigatorios(errors,frase)){
			return TELA_MANTER;
		}
		try {
			fraseService.salvar(frase);
			attributes.addFlashAttribute("mensagem","Frase salva com sucesso");
			return "redirect:/frases";
		} catch (IllegalArgumentException e) {
			return TELA_MANTER;
		}
	}

	private boolean validarCamposObrigatorios(Errors errors, Frase frase) {
		if(StringUtils.isEmpty(frase.getTituloFrase())){
			errors.rejectValue("tituloFrase", null, "O campo Título Frase não pode ser vazio");
		}

		if(StringUtils.isEmpty(frase.getDescricaoFrase())){
			errors.rejectValue("descricaoFrase", null, "O campo Descricao Frase não pode ser vazio");
		}
		if(StringUtils.isEmpty(frase.getAutorFrase())){
			errors.rejectValue("autorFrase", null, "O campo Autor Frase não pode ser vazio");
		}
		if(StringUtils.isEmpty(frase.getCategoriaFrase())){
			errors.rejectValue("categoriaFrase", null, "O campo Categoria Frase não pode ser vazio");
		}
		
		return errors.hasErrors();
	}
	
	@ModelAttribute("filtro")
	public FrasesFiltro getFraseFiltro(){
		return new FrasesFiltro();
	}
	
}
