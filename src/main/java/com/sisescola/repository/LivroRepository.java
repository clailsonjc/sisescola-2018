package com.sisescola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sisescola.models.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
