package com.project.the.library.service;

import java.util.List;

import com.project.the.library.model.Client;

public interface ClientService {
	List<Client> getAllCliens();

	void saveClient(Client client);

	Client getClientById(long id);

	void deleteClientById(long id);
}
