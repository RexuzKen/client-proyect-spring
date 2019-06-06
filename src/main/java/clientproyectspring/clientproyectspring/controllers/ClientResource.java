package clientproyectspring.clientproyectspring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import clientproyectspring.clientproyectspring.models.entity.Client;
import clientproyectspring.clientproyectspring.models.service.IClientService;

@RestController
@RequestMapping("/api/clientes")
public class ClientResource {
	
	@Autowired
	private IClientService clientService;
	
	@GetMapping
	public List<Client> findAll() {
		return clientService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client save(@Valid @RequestBody Client client) {
		return clientService.save(client);
	}
	
	@PutMapping("/{id}")
	public Client update(@PathVariable Long id,@Valid @RequestBody Client client) {
		return clientService.update(id, client);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		clientService.delete(id);
	}
}
