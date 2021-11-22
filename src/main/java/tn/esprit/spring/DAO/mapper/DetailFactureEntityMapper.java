package tn.esprit.spring.DAO.mapper;

import tn.esprit.spring.DAO.entity.DetailFactureEntity;
import tn.esprit.spring.service.model.DetailFacture;


public class DetailFactureEntityMapper {
    public static DetailFacture mapDetailFactureEntityToDetailFacture (DetailFactureEntity detailFactureEntity) {
        return new DetailFacture(detailFactureEntity.getIdDetailFacture(), detailFactureEntity.getQte(), detailFactureEntity.getPrixTotal(), detailFactureEntity.getPourcentageRemise(), detailFactureEntity.getMontantRemise() ,detailFactureEntity.getProduit() , FactureEntityMapper.mapFactureEntityToFacture(detailFactureEntity.getFacture()));
    }

    public static DetailFactureEntity mapDetailFactureToDetailFactureEntity (DetailFacture detailFacture) {
        return new DetailFactureEntity(detailFacture.getIdDetailFacture(), detailFacture.getQte(), detailFacture.getPrixTotal(), detailFacture.getPourcentageRemise(), detailFacture.getMontantRemise() ,detailFacture.getProduit() , FactureEntityMapper.mapFactureToFactureEntity(detailFacture.getFacture()));
    }


}
