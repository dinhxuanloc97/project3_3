package ra.model.serviceImp;

import ra.model.dao.CatalogDAO;
import ra.model.daoImp.CatalogDAOImp;
import ra.model.entity.Catalog;
import ra.model.service.CatalogService;

import java.util.List;

public class CatalogServiceImp implements CatalogService<Catalog,Integer> {

    private CatalogDAO<Catalog,Integer> catalogDAO = new CatalogDAOImp();
    @Override
    public List<Catalog> findAll() {
        return catalogDAO.findAll();
    }

    @Override
    public Catalog findById(Integer id) {
        return catalogDAO.findById(id);
    }

    @Override
    public boolean save(Catalog catalog) {
        return catalogDAO.save(catalog);
    }

    @Override
    public boolean update(Catalog catalog) {
        return catalogDAO.update(catalog);
    }

    @Override
    public boolean delete(Integer id) {
        return catalogDAO.delete(id);
    }

    @Override
    public List<Catalog> searchByName(String Name) {
        return catalogDAO.searchByName(Name);
    }



}
