package com.sisescola.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sisescola.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>  {
	
	List<Professor> findByOrderByNome();

}
