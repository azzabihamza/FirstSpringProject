package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.DetailFacture;
import tn.esprit.spring.repository.DetailFactureRepository;

import java.util.List;

@Service
public class DetailFactureServiceImpl implements DetailFactureService {

    @Autowired
    DetailFactureRepository detailFactureRepository;

    @Override
    public void addDetailFacture(DetailFacture detailFacture) {

    }

    @Override
    public void deleteDetailFacture(String id) {

    }

    @Override
    public void updateDetailFacture(DetailFacture detailFacture) {

    }

    @Override
    public DetailFacture getDetailFacture(String id) {
        return null;
    }

    @Override
    public List<DetailFacture> getAllDetailFactures() {
        return null;
    }
}
