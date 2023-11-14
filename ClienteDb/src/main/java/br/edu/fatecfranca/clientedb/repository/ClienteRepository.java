package br.edu.fatecfranca.clientedb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecfranca.clientedb.model.entity.Cliente;

public interface ClienteRepository
	extends JpaRepository<Cliente, Long>{

	// aqui não fazemos nada
	// esta interface vai herdar os métodos de CRUD
	// já associados a classe Produto que criamos
}