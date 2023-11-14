package br.edu.fatecfranca.clientedb.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // é uma entidade de banco de dados
@Table(name="cliente") // é uma tabela cliente
public class Cliente {
	
	@Id // chave primária
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="email")
	private String email;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="idade")
	private int idade;
	
	public Cliente() {
		
	}
	public Cliente(Long id, String nome, String email, String endereco, int idade) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.idade = idade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	@Override
	public String toString() {
		return "cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", endereco=" + endereco + ", idade="
				+ idade + "]";
	}
	
	
}
