package tn.esprit.spring.service;
import tn.esprit.spring.DAO.entity.DetailFactureEntity;

import java.util.List;

public interface DetailFactureService {
    public void addDetailFacture(DetailFactureEntity detailFacture);

    public void deleteDetailFacture(String id);

    public void updateDetailFacture(DetailFactureEntity detailFacture);

    public DetailFactureEntity getDetailFacture(String id);

    public List<DetailFactureEntity> getAllDetailFactures();

}
