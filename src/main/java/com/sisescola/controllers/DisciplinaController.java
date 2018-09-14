package com.sisescola.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sisescola.models.Disciplina;
import com.sisescola.services.DisciplinaService;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {
	
	@Autowired
	private DisciplinaService service;
		
	
	@GetMapping("/listar")
	public ModelAndView listar(Disciplina disciplina) {
		
		ModelAndView resultado = new ModelAndView("/admin/disciplina/listar");
		resultado.addObject(disciplina);
		resultado.addObject("listarDisciplinas", service.listarPorOrdem());		
		return resultado;
	}
	
	
	@PostMapping("/inserir")
	public ModelAndView inserir(@Valid Disciplina disciplina, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return listar(disciplina);
		}
	
		service.salvar(disciplina);
		attributes.addFlashAttribute("mensagem", "Salvo com sucesso!");
		return new ModelAndView("redirect:/disciplinas/listar");
	
	}
	
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id, RedirectAttributes attributes) {

		ModelAndView resultado = new ModelAndView("/admin/disciplina/listar");
		Disciplina disciplina = service.buscarPorId(id);
		if(disciplina == null) {
			attributes.addFlashAttribute("mensagem", "Edição Inválida! Selecione uma oferta válida!!!");
			return new ModelAndView("redirect:/disciplinas/listar");
		}else {
			resultado.addObject(disciplina);
			return resultado;
		}	
	
	}
	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		service.excluir(id);
		attributes.addFlashAttribute("mensagem", "Excluído com sucesso!");
		return "redirect:/disciplinas/listar";
	}	
	
	

}//fim class
