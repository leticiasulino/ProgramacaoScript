package br.edu.fatecfranca.clientedb.model.dto;

//Dto data transfer object.

public class ClienteDto {

	private Long id;
	private String nome;
	private String email;
	private String endereco;
	private int idade;
	
	public ClienteDto() {
		
	}
	public ClienteDto(Long id, String nome, String email, String endereco, int idade) {
		super();
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

}