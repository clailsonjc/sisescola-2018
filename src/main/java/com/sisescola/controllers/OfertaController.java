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

import com.sisescola.models.Oferta;
import com.sisescola.models.Turno;
import com.sisescola.services.OfertaService;

@Controller
@RequestMapping("/ofertas")
public class OfertaController {
	
	@Autowired
	private OfertaService service;

	@GetMapping("/listar")
	public ModelAndView listar(Oferta oferta) {

		ModelAndView resultado = new ModelAndView("/admin/oferta/listar");		
		resultado.addObject(oferta);
		resultado.addObject("turnos", Turno.values());
		resultado.addObject("listarOfertas", service.listarOfertaOrdemSerie());
		return resultado;
	}

	@PostMapping("/inserir")
	public ModelAndView inserir(@Valid Oferta oferta, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return listar(oferta);
		}
		service.salvar(oferta);
		attributes.addFlashAttribute("mensagem", "Salvo com sucesso!");
		return new ModelAndView("redirect:/ofertas/listar");
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id, RedirectAttributes attributes) {

		ModelAndView resultado = new ModelAndView("/admin/oferta/listar");
		Oferta oferta = service.buscarPorId(id);
			if (oferta == null) {
				attributes.addFlashAttribute("mensagem", "Edição Inválida! Selecione uma oferta válida!!!");
				return new ModelAndView("redirect:/ofertas/listar");
			}else {
				resultado.addObject("oferta", oferta);
				resultado.addObject("turnos", Turno.values());
				return resultado;
			}
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		service.excluir(id);
		attributes.addFlashAttribute("mensagem", "Excluído com sucesso!");
		return "redirect:/ofertas/listar";
	}
	

}// fim class
