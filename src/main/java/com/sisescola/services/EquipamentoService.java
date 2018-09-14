package com.sisescola.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisescola.models.Equipamento;
import com.sisescola.repositories.EquipamentoRepository;

@Service
public class EquipamentoService {

	@Autowired
	EquipamentoRepository repo;	

	//buscar por id
	public Equipamento buscarPorId(Long id) {
		Optional<Equipamento> prof = repo.findById(id);
		return prof.orElse(null);
	}
	
	//listar por ordem crescente de serie
	public List<Equipamento> listarOrdemNome(){		
		return repo.findByOrderByNome();
	}
	
	//salvar
	public void salvar(Equipamento equip) {
		repo.save(equip);
		
	}
	//excluir
	public void excluir(Long id) {
		repo.deleteById(id);	
	}
	
	
	
	
	

}// fim class

