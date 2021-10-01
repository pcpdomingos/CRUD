package br.org.generation.minhaFarmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_login")
public class Login {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull (message = "Por favor, digite seu nome de usuário")
	@Size (min = 20, max = 50, message = "O nome deve ser completo e conter entre dez a 40 caracteres")
	private String nome;
	
	@NotNull (message = "Por favor, insira a senha")
	@Size (min = 15, max = 20, message = "A senha deve conter entre 15 a 20 caracteres")
	private String senha;
	
	@ManyToOne
	@JsonIgnoreProperties("login")
	private Categoria categoria;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	

}
