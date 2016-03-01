package com.ProjetoFrases.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/frases")
public class FrasesController {

	private static final String TELA_PESQUISA = "/manterFrases/listFrases";
	private static final String TELA_MANTER = "/manterFrases/editFrases";
	
	
	@RequestMapping
	public String init(){
		return TELA_PESQUISA;
	}
	
	@RequestMapping("/novo")
	public ModelAndView carregarInclusão(){
		ModelAndView mv = new ModelAndView(TELA_MANTER);
		return mv;
	}
	
}
