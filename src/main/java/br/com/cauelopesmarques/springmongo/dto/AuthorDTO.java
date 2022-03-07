package br.com.cauelopesmarques.springmongo.dto;

import java.io.Serializable;

import br.com.cauelopesmarques.springmongo.domains.User;

public class AuthorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;
	
	public AuthorDTO() {
	}

	public AuthorDTO(User user) {
		this.id = user.getId();
		this.nome = user.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}		
}
