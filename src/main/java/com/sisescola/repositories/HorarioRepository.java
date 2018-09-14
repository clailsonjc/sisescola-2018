package com.sisescola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sisescola.models.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Long> {

}
