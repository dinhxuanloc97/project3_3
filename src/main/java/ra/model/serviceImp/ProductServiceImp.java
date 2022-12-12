package ra.model.serviceImp;

import ra.model.dao.ProductDAO;
import ra.model.daoImp.ProductDaoImp;
import ra.model.entity.Product;
import ra.model.service.ProductSevice;

import java.util.List;

public class ProductServiceImp implements ProductSevice<Product,String> {
    private ProductDAO<Product,String> productDAO = new ProductDaoImp();
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }
    @Override
    public Product findById(String id) {return productDAO.findById(id);
    }
    @Override
    public boolean save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public boolean update(Product product) {
        return productDAO.update(product);
    }

    @Override
    public boolean delete(String id) {
        return productDAO.delete(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productDAO.searchByName(name);
    }

    @Override
    public List<Product> getSpecialProduct() {
        return productDAO.getSpecialProduct();
    }

    @Override
    public List<Product> getProductlogId(String id) {
        return productDAO.getProductlogId(id) ;
    }
}
