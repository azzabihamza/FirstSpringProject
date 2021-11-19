package tn.esprit.spring.service;
import tn.esprit.spring.DAO.DetailFacture;

import java.util.List;

public interface DetailFactureService {
    public void addDetailFacture(DetailFacture detailFacture);

    public void deleteDetailFacture(String id);

    public void updateDetailFacture(DetailFacture detailFacture);

    public DetailFacture getDetailFacture(String id);

    public List<DetailFacture> getAllDetailFactures();

}
