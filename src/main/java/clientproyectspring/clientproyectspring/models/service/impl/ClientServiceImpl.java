package clientproyectspring.clientproyectspring.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import clientproyectspring.clientproyectspring.exceptions.ClientNotFoundException;
import clientproyectspring.clientproyectspring.models.entity.Client;
import clientproyectspring.clientproyectspring.models.repository.ClientRepository;
import clientproyectspring.clientproyectspring.models.service.IClientService;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Override
	public Client save(Client client) {
		client.setId(null);
		return clientRepository.save(client);
	}

	@Override
	public Client update(Long id, Client client) {
		clientRepository.findById(id)
			.orElseThrow(() -> new ClientNotFoundException("id", id.toString()));
		client.setId(id);
		return clientRepository.save(client);
	}

	@Override
	public void delete(Long id) {
		clientRepository.findById(id)
			.orElseThrow(() -> new ClientNotFoundException("id" , id.toString()));
		clientRepository.deleteById(id);	
	}

}
