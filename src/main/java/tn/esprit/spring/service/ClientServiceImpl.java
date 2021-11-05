package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.DAO.Client;
import tn.esprit.spring.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<Client> retrieveAllClients() {
		List<Client> clients = (List<Client>) clientRepository.findAll();
		for (Client client : clients) {
			System.out.println("Client :" + client);
		}
		return clients;
	}

	@Override
	public Client addClient(Client c) {
		clientRepository.save(c);
		return c;
	}

	@Override
	@Transactional
	public void deleteClient(Client c) {
		clientRepository.delete(c);
	}

	@Override
	@Transactional
	public Client updateClient(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public Client retrieveClient(Long id) {
		Client client = clientRepository.findById(id).orElse(null);
		System.out.println("Client :" + client);
		return client;
	}

}
