package tn.esprit.spring.repostry;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.dao.entity.Client;

public interface ClientRepostry extends CrudRepository <Client , Long > {

}
