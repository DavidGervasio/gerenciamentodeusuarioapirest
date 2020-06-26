package com.gerenciamentodeusuarioapirest.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gerenciamentodeusuarioapirest.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	//@Query("SELECT u FROM Usuario u INNER JOIN Cargo c WHERE u.cargo.id = id")
	@Query("SELECT u FROM Usuario u  WHERE  u.cargo.nome = 'Pedro'")
	List<Usuario> listaUsuariosVinculadosAoCurso(long id);

}