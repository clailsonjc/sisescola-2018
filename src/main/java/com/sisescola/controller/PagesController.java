package com.sisescola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller	
@RequestMapping("/pages")
public class PagesController {
	
	@GetMapping("/{nome}")
	public String navegar(@PathVariable String nome){
		System.out.println("teste="+nome);
		return "/pages/"+nome;
	}
		
	
	
	
	
	
	
	
	
	

}
