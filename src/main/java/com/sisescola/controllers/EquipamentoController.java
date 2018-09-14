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

import com.sisescola.models.Equipamento;
import com.sisescola.services.EquipamentoService;

@Controller
@RequestMapping("/equipamentos")
public class EquipamentoController {

	@Autowired
	private EquipamentoService service;

	@GetMapping("/listar")
	public ModelAndView listar(Equipamento equip) {
				
		ModelAndView resultado = new ModelAndView("/admin/equipamento/listar");		
		resultado.addObject(equip);
		resultado.addObject("listarEquipamentos", service.listarOrdemNome());
		return resultado;
	}

	@PostMapping("/inserir")
	public ModelAndView inserir(@Valid Equipamento equip, BindingResult result, RedirectAttributes attributes) {
						
		if (result.hasErrors()) {
			return listar(equip);
		}
		service.salvar(equip);
		attributes.addFlashAttribute("mensagem", "Salvo com sucesso!");
		return new ModelAndView("redirect:/equipamentos/listar");
	}

	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id, RedirectAttributes attributes) {

		ModelAndView resultado = new ModelAndView("/admin/equipamento/listar");
		Equipamento equip = service.buscarPorId(id);
			if (equip == null) {
				attributes.addFlashAttribute("mensagem", "Edição Inválida! Selecione um equipamento válido!!!");
				return new ModelAndView("redirect:/equipamentos/listar");
			}else {
				resultado.addObject("equipamento", equip);
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
