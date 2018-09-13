package com.sisescola.controller;

import java.util.List;
import java.util.Optional;

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

import com.sisescola.repository.OfertaRepository;
import com.sisescola.models.Oferta;
import com.sisescola.models.Turno;

@Controller
@RequestMapping("/ofertas")
public class OfertaController {
	
	@Autowired
	private OfertaRepository ofertaRepository;
	
	@GetMapping("/listar")
	public ModelAndView listar(Oferta oferta) {
		
		ModelAndView resultado = new ModelAndView("/admin/oferta/listar");
		List<Oferta> listar = ofertaRepository.findByOrderBySerie();
		resultado.addObject(oferta);
		resultado.addObject("turnos", Turno.values());
		resultado.addObject("listarOfertas",listar);
		return resultado;		
	}
	
	@PostMapping("/inserir")
	public ModelAndView inserir(@Valid Oferta oferta, BindingResult result, RedirectAttributes attributes) {	
		if(result.hasErrors()) {
			return listar(oferta);
		}			
		ofertaRepository.save(oferta);
		attributes.addFlashAttribute("mensagem", "Salvo com sucesso!");		
		return new ModelAndView("redirect:/ofertas/listar");
	}	
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable Long id) {
		
		ModelAndView resultado = new ModelAndView("/admin/oferta/listar");			
		Optional<Oferta> obj = ofertaRepository.findById(id);		
		resultado.addObject("oferta", obj.orElse(null));
		resultado.addObject("turnos", Turno.values());
				
		return resultado;
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		
		ofertaRepository.deleteById(id);
		attributes.addFlashAttribute("mensagem", "Excluído com sucesso!");
		return "redirect:/ofertas/listar";
		
	}
	
	
	
	
	

}//fim class
