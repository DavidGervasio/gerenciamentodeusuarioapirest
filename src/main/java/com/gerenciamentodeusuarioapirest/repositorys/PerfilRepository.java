package com.gerenciamentodeusuarioapirest.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciamentodeusuarioapirest.models.Cargo;
import com.gerenciamentodeusuarioapirest.models.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
	Perfil findById(long id);
}