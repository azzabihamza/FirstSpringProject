package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.DAO.entity.CategorieClient;
import tn.esprit.spring.DAO.entity.ClientEntity;
import tn.esprit.spring.DAO.entity.FactureEntity;
import tn.esprit.spring.DAO.entity.Profession;

public interface ClientService {

	List<ClientEntity> retrieveAllClients();

	ClientEntity addClient(ClientEntity u);
	ClientEntity addClientRepo(ClientEntity u);
	void deleteClient(Long id);
	ClientEntity updateClient(ClientEntity u);
	ClientEntity updateClientById(ClientEntity u,Long id);

	float getChiffreAffaireParCategorieClient(CategorieClient categorieClient, Date StartDate, Date endDate);
	float getMoneySpentByOneClient(Long idClient);
	List<ClientEntity> retrieveClientbyProfession(Profession Profession);
	List<ClientEntity> retrieveClientbyCategorie(CategorieClient CategorieClient);
	List<ClientEntity> retrieveClientbyCategorieAndProfession(Profession Profession , CategorieClient CategorieClient);

	// Long updateClientByProfession(CategorieClient c,Profession f);
	ClientEntity retrieveClient(long id);

	// void fixedRateMethod();
	//void cron1();
	//void statut_stock();

	int countnbrclient();
	float getChiffreAffaireParCategorieClient2(CategorieClient categorieClient,Date StartDate,Date endDate);
	int updateCategorieClient();
	List<FactureEntity> FactureParClient(long id);
	// List<Client> retrieveAllClientsFromDB(Profession c);
//	 Long deleteClientByCategorieClientAndProfession (CategorieClient c,Profession f);
	// List<Client> retrieveAllClientsByBirthday(Date debut,Date fin);

}
