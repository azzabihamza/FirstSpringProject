package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.DAO.entity.DetailFactureEntity;
import tn.esprit.spring.DAO.mapper.DetailFactureEntityMapper;
import tn.esprit.spring.repository.DetailFactureRepository;
import tn.esprit.spring.service.model.DetailFacture;

import java.util.List;

@Service
public class DetailFactureServiceImpl implements DetailFactureService {

    @Autowired
    DetailFactureRepository detailFactureRepository;

    @Override
    public void addDetailFacture(DetailFacture detailFacture) {
        detailFactureRepository.save(DetailFactureEntityMapper.mapDetailFactureToDetailFactureEntity(detailFacture));
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
    public DetailFactureEntity getDetailFacture(String id) {
        return null;
    }

    @Override
    public List<DetailFactureEntity> getAllDetailFactures() {
        return null;
    }
}
