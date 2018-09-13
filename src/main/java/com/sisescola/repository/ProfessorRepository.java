package com.sisescola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sisescola.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>  {

}
