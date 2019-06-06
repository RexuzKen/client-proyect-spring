package clientproyectspring.clientproyectspring.models.service;

import java.util.List;

import clientproyectspring.clientproyectspring.models.entity.Client;

public interface IClientService {
	
	List<Client> findAll();
	
	Client save(Client client);
	
	Client update(Long id, Client client);
	
	void delete(Long id);
	
}
