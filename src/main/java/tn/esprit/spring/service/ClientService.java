package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.DAO.entity.CategorieClient;
import tn.esprit.spring.DAO.entity.ClientEntity;
import tn.esprit.spring.DAO.Profession;

public interface ClientService {

	List<ClientEntity> retrieveAllClients();

	ClientEntity addClient(ClientEntity c);

	void deleteClient(ClientEntity c);

	ClientEntity updateClient(ClientEntity c);

	ClientEntity retrieveClient(Long id);

	List<ClientEntity> retrieveClientsProffession(Profession profession);

	int updateClientCategorieByProffession(CategorieClient categorieClient, Profession profession);

	void deleteClientByCategoryAndProffession(CategorieClient categorieClient, Profession profession);

	List<ClientEntity> retrieveAllClientsBetweenDate(String date1, String date2);
}
