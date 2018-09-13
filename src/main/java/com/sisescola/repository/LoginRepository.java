package com.sisescola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisescola.models.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

}
