package com.gerenciamentodeusuarioapirest.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamentodeusuarioapirest.models.Cargo;
import com.gerenciamentodeusuarioapirest.models.Usuario;
import com.gerenciamentodeusuarioapirest.repositorys.CargoRepository;
import com.gerenciamentodeusuarioapirest.repositorys.UsuarioRepository;
import com.gerenciamentodeusuarioapirest.utilidade.SimplesResposta;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class CargoController {

	@Autowired
	CargoRepository cargoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping("/cargos")
	public List<Cargo> listaCargos() {
		return cargoRepository.findAll();
	}

	@PutMapping("/cargos")
	public Cargo atualizaCargo(@RequestBody @Valid Cargo cargo) {
		return cargoRepository.save(cargo);
	}

	@DeleteMapping("/cargos/{id}")
	public SimplesResposta deletaCargo(@PathVariable(value = "id") long id) {
		Cargo cargo = cargoRepository.findById(id);
		  
		  if (!cargo.verificarSeHaUsuarioVinculado()) {
			  cargoRepository.delete(cargo);
				return new SimplesResposta("Cargo deletado com sucesso!");
		  } else {
				return new SimplesResposta("Cargo não pode ser deletado por possui usuário vinculado");

		  }
		 
	}
}