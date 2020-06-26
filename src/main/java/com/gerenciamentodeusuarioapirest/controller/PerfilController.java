package com.gerenciamentodeusuarioapirest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamentodeusuarioapirest.models.Cargo;
import com.gerenciamentodeusuarioapirest.models.Perfil;
import com.gerenciamentodeusuarioapirest.repositorys.PerfilRepository;
import com.gerenciamentodeusuarioapirest.utilidade.SimplesResposta;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class PerfilController {

	@Autowired
	PerfilRepository perfilRepository;

	@GetMapping("/perfis")
	public List<Perfil> listaPerfil() {
		return perfilRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}

	@PutMapping("/perfis")
	public Perfil atualizaPerfil(@RequestBody @Valid Perfil perfil) {
		return perfilRepository.save(perfil);
	}

	@DeleteMapping("/perfis/{id}")
	public SimplesResposta deletaPerfil(@PathVariable(value = "id") long id) {
		Perfil perfil = perfilRepository.findById(id);
		if (!perfil.verificarSeHaUsuarioVinculado()) {
			perfilRepository.delete(perfil);
			return new SimplesResposta("Perfil deletado com sucesso!");
		} else {
			return new SimplesResposta("Perfil não pode ser deletado por possui usuário vinculado");

		}

	}

}