package com.sisescola.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sisescola.models.Oferta;
import com.sisescola.repositories.OfertaRepository;

@Service
public class OfertaService {

	@Autowired
	OfertaRepository repo;	

	//buscar por id
	public Oferta buscarPorId(Long id) {
		Optional<Oferta> oferta = repo.findById(id);
		return oferta.orElse(null);
	}
	
	//listar por ordem crescente de serie
	public List<Oferta> listarOfertaOrdemSerie(){		
		return repo.findByOrderBySerie();
	}
	
	//salvar
	public void salvar(Oferta oferta) {
		repo.save(oferta);
		
	}
	//excluir
	public void excluir(Long id) {
		repo.deleteById(id);	
	}
	
	
	
	
	

}// fim class
