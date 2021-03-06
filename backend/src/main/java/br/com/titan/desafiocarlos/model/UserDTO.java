package br.com.titan.desafiocarlos.model;

import javax.validation.constraints.NotBlank;

public class UserDTO {
	
	private Long id;
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
	public UserDTO () {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
