package com.sisescola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sisescola.models.Local;


public interface LocalRepository extends JpaRepository<Local, Long> {
	
}
