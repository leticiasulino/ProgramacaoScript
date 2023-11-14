package br.edu.fatecfranca.clientedb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.fatecfranca.clientedb.model.dto.ClienteDto;
import br.edu.fatecfranca.clientedb.model.entity.Cliente;
import br.edu.fatecfranca.clientedb.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository injecao;
		
	// consulta no banco de dados é sempre o verbo GET
	@GetMapping 
	public List<ClienteDto> getClientes(){
		List<Cliente> clientes = injecao.findAll();
		return converteListaClientestoListaDtos(clientes);
	}
		
	// consulta no banco de dados por um produto em específico
	@GetMapping("/{id}")
	public ClienteDto getCliente(@PathVariable Long id) {
		Optional<Cliente> optional = injecao.findById(id);
		if (optional.isPresent()) {
			// obtem o produto encontrado e converte em dto
			return converteClienteToDto(optional.get());
		}
		return null; // não encontrou o produto
	}

	@PostMapping
	public ClienteDto addCliente(@RequestBody ClienteDto clienteDto) {
		// converte para produto pois enviaremos para o banco de dados
		Cliente cliente = converteDtoToCliente(clienteDto);
		// converte para dto pois enviaremos para o frontend
		return converteClienteToDto(injecao.save(cliente));
	}
		
	@DeleteMapping("/{id}")
	public String removeCliente(@PathVariable Long id) {
		if (injecao.existsById(id)) { // caso o produto exista
			injecao.deleteById(id); // remove
			return "Remoção com sucesso";
		}
		// não existe
		return "Cliente não existe";
	}
		
	@PutMapping()
	public ClienteDto updateCliente(@RequestBody ClienteDto clienteDto) {

		Cliente cliente = converteDtoToCliente(clienteDto);
		return converteClienteToDto(injecao.save(cliente));
	}
	
	public Cliente converteDtoToCliente(ClienteDto dto) {
		Cliente cliente = new Cliente();
		cliente.setId(dto.getId());
		cliente.setNome(dto.getNome());
		cliente.setEmail(dto.getEmail());
		cliente.setEndereco(dto.getEndereco());
		cliente.setIdade(dto.getIdade());
		return cliente;
	}
	public ClienteDto converteClienteToDto(Cliente cliente) {
		ClienteDto dto = new ClienteDto();
		dto.setId(cliente.getId());
		dto.setNome(cliente.getNome());
		dto.setEmail(cliente.getEmail());
		dto.setEndereco(cliente.getEndereco());
		dto.setIdade(cliente.getIdade());
		return dto;
	}

	public List<ClienteDto> converteListaClientestoListaDtos(List<Cliente> clientes){
		List<ClienteDto> listaDto = new ArrayList<ClienteDto>();

		for(int i=0;i<clientes.size();i++) {
			// converte produto em dto e coloca na lista de dto
			listaDto.add(converteClienteToDto(clientes.get(i)));
		}
		// retorna a lista de dto
		return listaDto;
	}
	
}