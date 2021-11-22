package tn.esprit.spring.service;
import tn.esprit.spring.DAO.entity.DetailFactureEntity;
import tn.esprit.spring.service.model.DetailFacture;

import java.util.List;

public interface DetailFactureService {
    public void addDetailFacture(DetailFacture detailFacture);

    public void deleteDetailFacture(Long id);

    public void updateDetailFacture(DetailFacture detailFacture);

    public DetailFacture getDetailFacture(Long id);

    public List<DetailFacture> getAllDetailFactures();

}
