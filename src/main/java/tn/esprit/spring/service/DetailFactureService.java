package tn.esprit.spring.service;
import tn.esprit.spring.DAO.entity.DetailFactureEntity;
import tn.esprit.spring.service.model.DetailFacture;

import java.util.List;

public interface DetailFactureService {
    public void addDetailFacture(DetailFacture detailFacture);

    public void deleteDetailFacture(String id);

    public void updateDetailFacture(DetailFactureEntity detailFacture);

    public DetailFactureEntity getDetailFacture(String id);

    public List<DetailFactureEntity> getAllDetailFactures();

}
