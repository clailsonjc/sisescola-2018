package com.sisescola.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisescola.models.Disciplina;
import com.sisescola.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	DisciplinaRepository repo;
	
	//listar por ordem nome
	public List<Disciplina> listarPorOrdem(){		
		return repo.findByOrderByNome();
	}
	
	//buscar por id
	public Disciplina buscarPorId(Long id) {
		Optional<Disciplina> disciplina = repo.findById(id);
		return disciplina.orElse(null);
	}
	
	//salvar
	public void salvar(Disciplina disciplina) {
		repo.save(disciplina);
	}
	
	//excluir
	public void excluir(Long id) {
		repo.deleteById(id);
	}
	
	
	
	
	
	
	
	
}//fim class
