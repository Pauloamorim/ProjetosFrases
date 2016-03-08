package com.ProjetoFrases.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/index")
public class IndexController {

	@RequestMapping()
	public String init(){
		System.out.println("entre");
		return "index";
	}
	
}
