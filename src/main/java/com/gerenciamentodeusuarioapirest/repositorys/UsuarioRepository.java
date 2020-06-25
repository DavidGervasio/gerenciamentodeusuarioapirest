package com.gerenciamentodeusuarioapirest.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciamentodeusuarioapirest.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}