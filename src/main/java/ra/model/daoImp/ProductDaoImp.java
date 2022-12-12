package ra.model.daoImp;

import ra.model.dao.ProductDAO;
import ra.model.entity.Catalog;
import ra.model.entity.Product;
import ra.model.util.ConnectionDB;

import javax.servlet.http.HttpSession;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImp implements ProductDAO<Product,String> {
    @Override
    public List<Product> findAll() {

        List<Product> listPro = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getAllProduct()}");
            ResultSet rs = callSt.executeQuery();
            listPro = new ArrayList<>();
            while (rs.next()){
                Product pro = new Product();
                pro.setProductId(rs.getString("productId"));
                pro.setProductName(rs.getString("productName"));
                pro.setPrice(rs.getFloat("price"));
                pro.setQuantity(rs.getInt("quantity"));
                pro.setProductImage(rs.getString("productImage"));
                pro.setDiscription(rs.getString("discription"));
                pro.setCatalogId(rs.getInt("catalogId"));
                pro.setProductStatus(rs.getBoolean("productStatus"));
                listPro.add(pro);
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listPro ;
    }
    @Override
    public Product findById(String id) {
        Product pro = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getProductById(?)}");
            callSt.setString(1,id);
            ResultSet rs = callSt.executeQuery();
            pro =  new Product();
            if (rs.next()){
                pro.setProductId(rs.getString("productId"));
                pro.setProductName(rs.getString("productName"));
                pro.setPrice(rs.getFloat("price"));
                pro.setQuantity(rs.getInt("quantity"));
                pro.setProductImage(rs.getString("productImage"));
                pro.setDiscription(rs.getString("discription"));
                pro.setCatalogId(rs.getInt("catalogId"));
                pro.setProductStatus(rs.getBoolean("productStatus"));
             }
        }catch (SQLException ex1){
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return pro;
    }
    @Override
    public boolean save(Product product) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_insertProduct(?,?,?,?,?,?,?,?)}");
                callSt.setString(1, product.getProductId());
                callSt.setString(2,product.getProductName());
                callSt.setFloat(3,product.getPrice());
                callSt.setInt(4,product.getQuantity());
                callSt.setString(5,product.getProductImage());
                callSt.setString(6,product.getDiscription());
                callSt.setInt(7,product.getCatalogId());
                callSt.setBoolean(8,product.isProductStatus());
                callSt.executeUpdate();
        }catch (SQLException ex1){
            result = false;
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }
    @Override
    public boolean update(Product product) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_updateProduct(?,?,?,?,?,?,?,?)}");
            callSt.setString(1,product.getProductId());
            callSt.setString(2,product.getProductName());
            callSt.setFloat(3,product.getPrice());
            callSt.setInt(4,product.getQuantity());
            callSt.setString(5,product.getProductImage());
            callSt.setString(6,product.getDiscription());
            callSt.setInt(7,product.getCatalogId());
            callSt.setBoolean(8,product.isProductStatus());
            callSt.executeUpdate();
        }catch (SQLException ex1){
            result = false;
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_UpdateproductStatus(?)}");
            callSt.setString(1,id);
            callSt.executeUpdate();
        }catch (SQLException ex1){
            result = false;
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }
    @Override
    public List<Product> searchByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> listProduct = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_searchProductName(?)}");
            listProduct = new ArrayList<>();
            callSt.setString(1,name);
            ResultSet rs = callSt.executeQuery();
            listProduct = new ArrayList<>();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductId(rs.getString("productId"));
                pro.setProductName(rs.getString("productName"));
                pro.setPrice(rs.getFloat("price"));
                pro.setQuantity(rs.getInt("quantity"));
                pro.setProductImage(rs.getString("productImage"));
                pro.setDiscription(rs.getString("discription"));
                pro.setCatalogId(rs.getInt("catalogId"));
                pro.setProductStatus(rs.getBoolean("productStatus"));
                listProduct.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listProduct;
    }

    @Override
    public List<Product> getSpecialProduct() {
        List<Product> listPro = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getSpecialProduct()}");
            ResultSet rs = callSt.executeQuery();
            listPro = new ArrayList<>();
            while (rs.next()){
                Product pro = new Product();
                pro.setProductId(rs.getString("productId"));
                pro.setProductName(rs.getString("productName"));
                pro.setPrice(rs.getFloat("price"));
                pro.setQuantity(rs.getInt("quantity"));
                pro.setProductImage(rs.getString("productImage"));
                pro.setDiscription(rs.getString("discription"));
                pro.setCatalogId(rs.getInt("catalogId"));
                pro.setProductStatus(rs.getBoolean("productStatus"));
                listPro.add(pro);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listPro ;
    }

    @Override
    public List<Product> getProductlogId(String id) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> listProduct = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getProductByCatalogId(?)}");
            listProduct = new ArrayList<>();
            callSt.setString(1,id);
            ResultSet rs = callSt.executeQuery();
            listProduct = new ArrayList<>();
            while (rs.next()) {
                Product pro = new Product();
                pro.setProductId(rs.getString("productId"));
                pro.setProductName(rs.getString("productName"));
                pro.setPrice(rs.getFloat("price"));
                pro.setQuantity(rs.getInt("quantity"));
                pro.setProductImage(rs.getString("productImage"));
                pro.setDiscription(rs.getString("discription"));
                pro.setCatalogId(rs.getInt("catalogId"));
                pro.setProductStatus(rs.getBoolean("productStatus"));
                listProduct.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listProduct;
    }
}
