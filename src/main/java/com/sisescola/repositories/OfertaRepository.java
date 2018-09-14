package com.sisescola.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sisescola.models.Oferta;

public interface OfertaRepository extends JpaRepository<Oferta, Long> {
	
	List<Oferta> findByOrderBySerie();

}
