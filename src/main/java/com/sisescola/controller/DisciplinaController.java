package com.sisescola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sisescola.repository.DisciplinaRepository;
import com.sisescola.models.Disciplina;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaRepository repositorioDisciplina;
		
	
	@GetMapping("/listar")
	public ModelAndView listar() {
		
		ModelAndView resultado = new ModelAndView("/disciplina/listarDisciplina");
		List<Disciplina> listar = repositorioDisciplina.findAll();
		resultado.addObject("listarDisciplinas", listar);
		
		return resultado;
	}
	
	

}//fim class
