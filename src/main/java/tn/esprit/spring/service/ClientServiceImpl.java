package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.DAO.entity.CategorieClient;
import tn.esprit.spring.DAO.entity.ClientEntity;
import tn.esprit.spring.DAO.Profession;
import tn.esprit.spring.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;

	@Override
	public List<ClientEntity> retrieveAllClients() {
		List<ClientEntity> clients = (List<ClientEntity>) clientRepository.findAll();
		for (ClientEntity client : clients) {
			System.out.println("Client :" + client);
		}
		return clients;
	}

	@Override
	public ClientEntity addClient(ClientEntity c) {
		clientRepository.save(c);
		return c;
	}

	@Override
	@Transactional
	public void deleteClient(ClientEntity c) {
		clientRepository.delete(c);
	}

	@Override
	@Transactional
	public ClientEntity updateClient(ClientEntity c) {
		return clientRepository.save(c);
	}

	@Override
	public ClientEntity retrieveClient(Long id) {
		ClientEntity client = clientRepository.findById(id).orElse(null);
		System.out.println("Client :" + client);
		return client;
	}

	@Override
	public List<ClientEntity> retrieveClientsProffession(Profession profession) {
		return clientRepository.retrieveClientsByProffession(profession);
	}

	@Override
	public int updateClientCategorieByProffession(CategorieClient categorieClient, Profession profession) {
		return clientRepository.updateClientCategorieByProffession(categorieClient, profession);
	}

	@Override
	public void deleteClientByCategoryAndProffession(CategorieClient categorieClient, Profession profession) {
		clientRepository.deleteClientByCategorieClientAndProfession(categorieClient, profession);
	}

	@Override
	public List<ClientEntity> retrieveAllClientsBetweenDate(String date1, String date2) {
		return clientRepository.retrieveClientsBetweenDates(date1, date2);
	}
}
