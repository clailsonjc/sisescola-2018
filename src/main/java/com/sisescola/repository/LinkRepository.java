package com.sisescola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisescola.models.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {

}
