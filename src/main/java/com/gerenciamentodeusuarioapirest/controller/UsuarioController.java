package com.gerenciamentodeusuarioapirest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamentodeusuarioapirest.models.Cargo;
import com.gerenciamentodeusuarioapirest.models.Usuario;
import com.gerenciamentodeusuarioapirest.models.Perfil;
import com.gerenciamentodeusuarioapirest.repositorys.CargoRepository;
import com.gerenciamentodeusuarioapirest.repositorys.PerfilRepository;
import com.gerenciamentodeusuarioapirest.repositorys.UsuarioRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	CargoRepository cargoRepository;

	@Autowired
	PerfilRepository perfilRepository;

	@GetMapping("/usuarios")
	public List<Usuario> listaUsuario() {
		return usuarioRepository.findAll();
	}

	@PostMapping("/usuarios")
	public Usuario salvaUsuario(@RequestBody @Valid Usuario usuario) {
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		atualizarVinculoEntreCargoEUsuarios(usuarioSalvo);
		atualizarVinculoEntrePerfilEUsuarios(usuario);
		return usuarioSalvo;
	}

	@PutMapping("/usuarios")
	public Usuario atualizaUsuario(@RequestBody @Valid Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	private void atualizarVinculoEntreCargoEUsuarios(Usuario usuario) {
		Cargo cargo = cargoRepository.findById(usuario.getCargo().getId());
		cargo.inserirUsuario(usuario);
		cargoRepository.save(cargo);
	}

	private void atualizarVinculoEntrePerfilEUsuarios(Usuario usuario) {
		List<Perfil> perfis = usuario.getPerfis();
		for (Perfil perfil : perfis) {
			Perfil perfilParaSerAtualizado = perfilRepository.findById(perfil.getId());
			perfilParaSerAtualizado.inserirUsuario(usuario);
			perfilRepository.save(perfilParaSerAtualizado);
		}
	}

}
