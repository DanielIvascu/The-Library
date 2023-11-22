package com.project.the.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.the.library.model.Client;
import com.project.the.library.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public List<Client> getAllCliens() {
		return clientRepository.findAll();
	}

	@Override
	public void saveClient(Client client) {
		this.clientRepository.save(client);

	}

	@Override
	public Client getClientById(long id) {
		Optional<Client> optional = clientRepository.findById(id);
		Client client = null;
		if (optional.isPresent()) {
			client = optional.get();
		} else {
			throw new RuntimeException("Client not found for id ::" + id);
		}
		return client;
	}

	@Override
	public void deleteClientById(long id) {
		this.clientRepository.deleteById(id);

	}

}
