package br.org.generation.minhaFarmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull (message = "Por favor, identifique o produto")
	@Size (min = 10, max = 50, message = "Por favor, poderia especificar melhor o produto ?")
	private String produto;
	
	@NotNull (message = "Por favor, digite a quantidade de produtos")
	@Size (min = 1, max = 3, message = "Só é possível adquirir de um há 100 produtos no momento")
	private int quantidade;
	
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Login> login;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getProduto() {
		return produto;
	}


	public void setProduto(String produto) {
		this.produto = produto;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public List<Login> getLogin() {
		return login;
	}


	public void setLogin(List<Login> login) {
		this.login = login;
	}
	
	
	

}
