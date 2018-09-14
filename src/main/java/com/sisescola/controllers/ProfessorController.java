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

import com.sisescola.models.Professor;
import com.sisescola.services.ProfessorService;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

	@Autowired
	private ProfessorService service;

	@GetMapping("/listar")
	public ModelAndView listar(Professor prof) {

		ModelAndView resultado = new ModelAndView("/admin/professor/listar");		
		resultado.addObject(prof);
		//resultado.addObject("turnos", Turno.values());
		resultado.addObject("listarProfessores", service.listarOrdemNome());
		return resultado;
	}

	@PostMapping("/inserir")
	public ModelAndView inserir(@Valid Professor prof, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return listar(prof);
		}
		service.salvar(prof);
		attributes.addFlashAttribute("mensagem", "Salvo com sucesso!");
		return new ModelAndView("redirect:/professores/listar");
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id, RedirectAttributes attributes) {

		ModelAndView resultado = new ModelAndView("/admin/professor/listar");
		Professor prof = service.buscarPorId(id);
			if (prof == null) {
				attributes.addFlashAttribute("mensagem", "Edição Inválida! Selecione uma oferta válida!!!");
				return new ModelAndView("redirect:/professores/listar");
			}else {
				resultado.addObject("professor", prof);
				//resultado.addObject("turnos", Turno.values());
				return resultado;
			}
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		service.excluir(id);
		attributes.addFlashAttribute("mensagem", "Excluído com sucesso!");
		return "redirect:/professores/listar";
	}
	

}// fim class
