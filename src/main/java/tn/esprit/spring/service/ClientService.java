package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.DAO.Client;

public interface ClientService {

	List<Client> retrieveAllClients();

	Client addClient(Client c);

	void deleteClient(Client c);

	Client updateClient(Client c);

	Client retrieveClient(Long id);

}
