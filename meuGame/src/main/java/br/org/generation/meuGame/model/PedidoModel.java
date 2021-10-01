package br.org.generation.meuGame.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table (name = "tb_pedido")
public class PedidoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull (message = "Insira seu nome para que possamos te conhecer")
	@Size(min = 20, max = 50, message = "O nome deve ser completo e conter o mínimo de vinte caracteres e o máximo de cinquenta")
	private String nome;
	
	@NotNull (message = "O email é necessário pois será nosso meio de comunicação")
	@Size(min = 20, max = 50, message = "O email deve conter o mínimo de vinte caracteres e o máximo de cinquenta")
	private String email;
	
	@NotNull (message = "Insira seu endereço para que possamos levar seu produto até você")
	@Size(min = 20, max = 50, message = "O endereço deve conter o mínimo de vinte caracteres e o máximo de cinquenta")
	private String endereco;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JsonIgnoreProperties("pedido")
	private CategoriaModel categoria;

	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

	
	
	
}
