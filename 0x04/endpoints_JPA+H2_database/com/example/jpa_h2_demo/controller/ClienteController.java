package com.example.jpa_h2_demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.jpa_h2_demo.model.Cliente;
import com.example.jpa_h2_demo.repository.ClienteRepository;

@RestController
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@PostMapping("/addClient")
	public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);
	}

	@GetMapping("/findAllClients")
	public ResponseEntity<List<Cliente>> findAllClients() {
		List<Cliente> clientes = clienteRepository.findAll();
		return ResponseEntity.ok(clientes);
	}

	@GetMapping("/findClientById/{id}")
	public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
		Optional<Cliente> cliente = clienteRepository.findById(idClient);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente de Id: " + idClient + " não encontrado");
		}
	}

	@DeleteMapping("/removeClientById/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerCliente(@PathVariable("id") Long idClient) {
		clienteRepository.deleteById(idClient);
	}

	@PutMapping("/updateClientById/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		Optional<Cliente> customer = clienteRepository.findById(id);

		if (customer.isPresent()) {
			Cliente customerUpdated = customer.get();
			customerUpdated.setNome(cliente.getNome());
			customerUpdated.setEmail(cliente.getEmail());
			customerUpdated.setIdade(cliente.getIdade());
			customerUpdated.setEnderecos(cliente.getEnderecos());
			customerUpdated.setTelefones(cliente.getTelefones());

			clienteRepository.save(customerUpdated);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente de Id: " + id + " não encontrado");
		}
	}
}