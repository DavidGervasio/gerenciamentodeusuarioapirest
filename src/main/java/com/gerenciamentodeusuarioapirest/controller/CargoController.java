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
import com.gerenciamentodeusuarioapirest.repositorys.CargoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class CargoController {

	@Autowired
	CargoRepository cargoRepository;

	@GetMapping("/cargos")
	public List<Cargo> listaCargos() {
		return cargoRepository.findAll();
	}

	@PutMapping("/cargos")
	public Cargo atualizaCargo(@RequestBody @Valid Cargo cargo) {
		return cargoRepository.save(cargo);
	}

	@DeleteMapping("/cargos")
	public void deletaCargo(@RequestBody @Valid Cargo cargo) {
		cargoRepository.delete(cargo);
	}

	

}