package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.dao.entity.Client;

public interface IClientService {
	public List <Client> retrieveAllClient(); 
	public Client addClient(Client c); 
	public void deleteClient (Long id); 
	public Client UpdateClient (Client c ) ; 
	public Client retrieveClient(Long id );
}
