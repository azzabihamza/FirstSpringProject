package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.DAO.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
