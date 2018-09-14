package com.sisescola.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sisescola.models.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
	
	List<Disciplina> findByOrderByNome();

}
