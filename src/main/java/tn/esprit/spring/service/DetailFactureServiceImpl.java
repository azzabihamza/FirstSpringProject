package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.mapper.DetailFactureEntityMapper;
import tn.esprit.spring.DAO.model.Facture;
import tn.esprit.spring.repository.DetailFactureRepository;
import tn.esprit.spring.DAO.model.DetailFacture;

import java.util.List;

@Service
public class DetailFactureServiceImpl implements DetailFactureService {

    @Autowired
    DetailFactureRepository detailFactureRepository;

    @Autowired
    FactureService factureService;

    @Override
    public void addDetailFacture(DetailFacture detailFacture) {
        Facture facture = factureService.retrieveFacture(detailFacture.getFacture().getIdFacture());
        if (facture != null) {
            detailFacture.setFacture(facture);
            detailFactureRepository.save(DetailFactureEntityMapper.mapDetailFactureToDetailFactureEntity(detailFacture));
        }
    }

    @Override
    public void deleteDetailFacture(Long id) {
        detailFactureRepository.deleteById(id);
    }

    @Override
    public void updateDetailFacture(DetailFacture detailFacture) {
        detailFactureRepository.save(DetailFactureEntityMapper.mapDetailFactureToDetailFactureEntity(detailFacture));
    }

    @Override
    public DetailFacture getDetailFacture(Long id) {
        return DetailFactureEntityMapper.mapDetailFactureEntityToDetailFacture(detailFactureRepository.retieveDetailFactureById(id));
    }

    @Override
    public List<DetailFacture> getAllDetailFactures() {
        return DetailFactureEntityMapper.mapListDetailFactureEntityToDetailFactureList(detailFactureRepository.findAll());
    }
}
