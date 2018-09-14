package com.sisescola.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisescola.models.Professor;
import com.sisescola.repositories.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository repo;	

	//buscar por id
	public Professor buscarPorId(Long id) {
		Optional<Professor> prof = repo.findById(id);
		return prof.orElse(null);
	}
	
	//listar por ordem crescente de serie
	public List<Professor> listarOrdemNome(){		
		return repo.findByOrderByNome();
	}
	
	//salvar
	public void salvar(Professor prof) {
		repo.save(prof);
		
	}
	//excluir
	public void excluir(Long id) {
		repo.deleteById(id);	
	}
	
	
	
	
	

}// fim class
