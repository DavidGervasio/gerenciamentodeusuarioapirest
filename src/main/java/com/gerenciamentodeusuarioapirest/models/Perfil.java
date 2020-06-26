package com.gerenciamentodeusuarioapirest.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "TB_PERFIL")
public class Perfil implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(unique = true)
	@NonNull
	private String nome;

	@ManyToMany
	private List<Usuario> usuarios;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void inserirUsuario(Usuario usuario){
		if(usuarios== null){
			usuarios = new ArrayList<Usuario>();
		}
		usuarios.add(usuario);
	}
	
	public boolean verificarSeHaUsuarioVinculado (){
		if(usuarios.isEmpty()){
			return false;
		}else{
			return true;
		}
	}

}