package com.gerenciamentodeusuarioapirest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamentodeusuarioapirest.models.Cargo;
import com.gerenciamentodeusuarioapirest.models.Perfil;
import com.gerenciamentodeusuarioapirest.repositorys.PerfilRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class PerfilController {

	@Autowired
	PerfilRepository perfilRepository;

	@GetMapping("/perfis")
	public List<Perfil> listaPerfil() {
		return perfilRepository.findAll();
	}

	@PutMapping("/perfis")
	public Perfil atualizaPerfil(@RequestBody @Valid Perfil perfil) {
		return perfilRepository.save(perfil);
	}

	@DeleteMapping("/perfis")
	public void deletaPerfil(@RequestBody @Valid Perfil perfil) {
		perfilRepository.delete(perfil);
	}



}