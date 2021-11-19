package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.entity.DetailFactureEntity;
import tn.esprit.spring.repository.DetailFactureRepository;

import java.util.List;

@Service
public class DetailFactureServiceImpl implements DetailFactureService {

    @Autowired
    DetailFactureRepository detailFactureRepository;

    @Override
    public void addDetailFacture(DetailFactureEntity detailFacture) {

    }

    @Override
    public void deleteDetailFacture(String id) {

    }

    @Override
    public void updateDetailFacture(DetailFactureEntity detailFacture) {

    }

    @Override
    public DetailFactureEntity getDetailFacture(String id) {
        return null;
    }

    @Override
    public List<DetailFactureEntity> getAllDetailFactures() {
        return null;
    }
}
