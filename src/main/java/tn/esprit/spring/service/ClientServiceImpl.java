package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dao.entity.Client;
import tn.esprit.spring.dao.entity.Facture;
import tn.esprit.spring.repostry.*;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	ClientRepostry clientRepostry ; 
	
	@Override
	public List<Client> retrieveAllClient() {
		// TODO Auto-generated method stub
		System.out.println(clientRepostry.findAll());
		
		return (List<Client>) clientRepostry.findAll();
	
	}

	@Override
	public Client addClient(Client c) {
		// TODO Auto-generated method stub
		List<Client> clients = new ArrayList<Client>();
		clients.add(clientRepostry.save(c));
		return c;
	}

	@Override
	public void deleteClient(Long id) {
		// TODO Auto-generated method stub
		clientRepostry.deleteById(id);

		
	}

	@Override
	public Client UpdateClient(Client c) {
		// TODO Auto-generated method stub
		List<Client> clients =(List<Client>) clientRepostry.save(c);
		return c;
	
	}

	@Override
	public Client retrieveClient(Long id) {
		// TODO Auto-generated method stub
		return clientRepostry.findById(id).get();
	}

}
