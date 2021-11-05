package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.DAO.CategorieClient;
import tn.esprit.spring.DAO.Client;
import tn.esprit.spring.DAO.Profession;

public interface ClientService {

	List<Client> retrieveAllClients();

	Client addClient(Client c);

	void deleteClient(Client c);

	Client updateClient(Client c);

	Client retrieveClient(Long id);

	List<Client> retrieveClientsProffession(Profession profession);

	int updateClientCategorieByProffession(CategorieClient categorieClient, Profession profession);

	void deleteClientByCategoryAndProffession(CategorieClient categorieClient, Profession profession);

	List<Client> retrieveAllClientsBetweenDate(String date1, String date2);
}
