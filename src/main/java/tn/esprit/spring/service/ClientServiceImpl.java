package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import tn.esprit.spring.DAO.entity.CategorieClient;
import tn.esprit.spring.DAO.entity.ClientEntity;
import tn.esprit.spring.DAO.entity.FactureEntity;
import tn.esprit.spring.DAO.entity.Profession;
import tn.esprit.spring.repository.ClientRepository;
import tn.esprit.spring.repository.FactureRepository;
import tn.esprit.spring.repository.StockRepository;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	EmailServiceImpl emailService;
	@Autowired
	FactureRepository FactureRepo;
	@Autowired
	StockRepository StockRepository;

	@Override
	public List<ClientEntity> retrieveAllClients() {
		List<ClientEntity> clients = (List<ClientEntity>) clientRepository.findAll();
		for (ClientEntity client : clients) {
			System.out.println("Client :" + client);
		}
		return clients;
	}

	@Override
	public  List<FactureEntity> FactureParClient(long id){
		return clientRepository.FactureParClient(id);

	}
/*	public List<Client> retrieveAllClientsByBirthday(Date debut,Date fin)
	{
		return clientRepository.retrieveAllClientsByBirthday(debut, fin);
	}*/

	@Override
	public ClientEntity addClient(ClientEntity u) {

		clientRepository.save(u);
		return u;
	}


	public ClientEntity addClientRepo(ClientEntity u) {

		clientRepository.insertClient(u.getNom(), u.getPrenom(), u.getDateNaissance(),u.getEmail(), u.getPassword(), u.getProfession(), u.getCategorieClient());
		return u;
	}


	@Override
	public void deleteClient(Long id) {

		clientRepository.deleteById(id);

	}





	@Override
	public
	List<ClientEntity> retrieveClientbyProfession(Profession Profession){
		return clientRepository.retrieveClientByProfession(Profession);

	}

	@Override
	public List<ClientEntity> retrieveClientbyCategorie(CategorieClient categorieClient) {
		return clientRepository.retrieveClientByCategorie(categorieClient);


	}

	@Override
	public ClientEntity updateClient(ClientEntity u) {
		long id= u.getIdClient();
		Optional<ClientEntity> Clients = clientRepository.findById(id);

		if(Clients!=null)
			clientRepository.save(u);

		return u;
	}



/*
	public Long updateClientByProfession(CategorieClient c,Profession f) {
	 return clientRepository.updateClientCategorieByProfession(c,f);
	}

	public Long deleteClientByCategorieClientAndProfession(CategorieClient c,Profession f) {
		 return clientRepository.deleteClientByCategorieClientAndProfession(c,f);
		}
		*/

	@Override
	public ClientEntity retrieveClient(long id) {

		ClientEntity Client = null;

		try {
			Client = clientRepository.findById(id).get();

		}
		catch(NullPointerException e) {
			System.out.println("NullPointerException thrown!");
		}

		return Client;
	}



	@Override
	public ClientEntity updateClientById(ClientEntity u, Long id) {
		long idd= u.getIdClient();
		if(id==idd)
		{
			Optional<ClientEntity> Clients = clientRepository.findById(id);

			if(Clients!=null)
				clientRepository.save(u);
		}
		return u;
	}

	 /*
	@Scheduled(fixedRate = 60000)
	@Override
	public void statut_stock(){
		 List<Stock> stocks = (List<Stock>) StockRepository.findAll();
	        for(Stock stock :stocks)
	        {
	        	 System.out.println("stock ++ " +stock.getQteStock());
	        	 if(stock.getQteStock()==0){
	        		 System.out.println("stock perime");}else
	        			 System.out.println("stock non perime");

	    }
	        }
	*/

	public List<ClientEntity> retrieveClientbyCategorieAndProfession(Profession Profession , CategorieClient CategorieClient)
	{

		return clientRepository.retrieveClientByProfessionANDcategorie(Profession, CategorieClient)	 ;

	}

	public float getMoneySpentByOneClient(Long idClient){

		List<FactureEntity> factures = clientRepository.FactureParClient(idClient);
		float totale=0;

		for(FactureEntity facture: factures){

			totale = totale+ facture.getMontantFacture();

		}
		return totale;

	}

	//private static final Logger L = LogManager.getLogger(ProduitServiceImpl.class);
/*
	public List<Client> retrieveAllClientsFromDB(Profession Profession){
		return clientRepository.retrieveAllClientsByProfession(Profession);

	}
*/
	/*@Scheduled(fixedRate = 60000)
	public void fixedRateMethod() {
	System.out.println("Method with fixed");
	}
	*/
//	@Scheduled(cron = "*/60 * * * * *")
	//public void cron1() {
	//System.out.println("cron */60 ");
	//}

	//methode1
	public  float getChiffreAffaireParCategorieClient(CategorieClient categorieClient,Date StartDate,Date endDate)
	{
		List<ClientEntity> Clients = (List<ClientEntity>) clientRepository.retrieveClientByCategorie(categorieClient);
		List<FactureEntity> Factures = (List<FactureEntity>) FactureRepo.findAll();

		float totale=0;

		for(ClientEntity client: Clients){
			for(FactureEntity facture: Factures){

				if(client.getIdClient()==facture.getClient().getIdClient())
				{
					totale = totale+ facture.getMontantFacture();
				}


			}
		}
		return totale;
	}

	//methode2
	public  float getChiffreAffaireParCategorieClient2(CategorieClient categorieClient, Date StartDate, Date endDate)
	{
		List<FactureEntity> Factures = (List<FactureEntity>) clientRepository.FactureClientByCategorie(categorieClient);

		float totale=0;

		for(FactureEntity facture: Factures){

			totale = totale+ facture.getMontantFacture();

		}
		return totale;
	}

	public int countnbrclient(){

		return clientRepository.coutnbreClient();
	}

	//Methode qui met a jour la categorie des clients chaque 30 min en fonction du nombre d'achat qu'ils ont effectué
	//En fonction du nombre d'achat, leur catégorie change et il reçoive un code promo par mail pour leur prochains achats
	//@Scheduled(cron = "*/20 * * * * *")

	@Scheduled(cron = "0 0/30 * * * *")
	@Override
	public int updateCategorieClient()
	{
		List<ClientEntity> Clients = (List<ClientEntity>) clientRepository.findAll();
		for(ClientEntity client: Clients){
			//	System.out.println("clients +++: " + client );

			System.out.println("verif de la categorie");
			if(client.getFactures().size()<=3 && client.getCategorieClient()!=CategorieClient.ORDINAIRE )
			{

				System.out.println("le client "+client.getNom()+" "+client.getPrenom()+" a "+client.getFactures().size()+" factures");
				clientRepository.updateCategorieClient(client.getIdClient(),CategorieClient.ORDINAIRE);

			}
			if(client.getFactures().size()>=4 && client.getFactures().size()<=5  && client.getCategorieClient()!=CategorieClient.FIDELE)
			{
				String text="Bonjour "+client.getPrenom()+" "+client.getNom()+".\n\nVous êtes désormais un client "
						+ "fidéle chez Best Shop. Pour vous remercier de voter confiance, vous bénéficierez d'une remise de 5% pour "
						+ "tout vos prochains achat.\n\n Merci et à bientôt";

				System.out.println("le client "+client.getNom()+" "+client.getPrenom()+" a "+client.getFactures().size()+" factures");


				clientRepository.updateCategorieClient(client.getIdClient(),CategorieClient.FIDELE);


				try {
					emailService.sendSimpleMessage(client.getEmail(), "Magasin Best Shop", text);

				} catch (Exception e) {
					// TODO: handle exception
				}

			}
			if(client.getFactures().size()>=6 && client.getCategorieClient()!=CategorieClient.PRENUIM)
			{
				String text="Bonjour "+client.getPrenom()+" "+client.getNom()+".\n\nVous êtes désormais un client "
						+ "fidéle chez Best Shop. Pour vous remercier de voter confiance, vous bénéficierez d'une remise de 10% pour "
						+ "tout vos prochains achat.\n\n Merci et à bientôt";

				System.out.println("le client "+client.getNom()+" "+client.getPrenom()+" a "+client.getFactures().size()+" factures");

				clientRepository.updateCategorieClient(client.getIdClient(),CategorieClient.PRENUIM);


				try {
					emailService.sendSimpleMessage(client.getEmail(), "Magasin Best Shop", text);

				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		}
		return 1;
	}
}
