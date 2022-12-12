package ra.model.daoImp;

import ra.model.dao.CatalogDAO;
import ra.model.entity.Catalog;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogDAOImp implements CatalogDAO<Catalog,Integer> {
    @Override
    public List<Catalog> searchByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Catalog> listCatalog = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_searchCatalogbyName(?)}");
           listCatalog = new ArrayList<>();
           callSt.setString(1,name);
           ResultSet rs = callSt.executeQuery();
           listCatalog = new ArrayList<>();
            while (rs.next()) {
                Catalog ca = new Catalog();
                ca.setCatalogId(rs.getInt("catalogId"));
                ca.setCatalogName(rs.getString("catalogName"));
                ca.setCatalogStatus(rs.getBoolean("catalogStatus"));
                listCatalog.add(ca);
            }
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listCatalog;
    }

    @Override
    public List<Catalog> findAll()  {
        List<Catalog> listCat = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getAllCatalog()}");
            ResultSet rs = callSt.executeQuery();
            listCat = new ArrayList<>();
            while (rs.next()){
                Catalog cat = new Catalog();
                cat.setCatalogId(rs.getInt("catalogId"));
                cat.setCatalogName(rs.getString("catalogName"));
                cat.setCatalogStatus(rs.getBoolean("catalogStatus"));
                listCat.add(cat);
            }
        }catch (SQLException ex1){
            ex1.printStackTrace();
        }finally {
          ConnectionDB.closeConnection(conn,callSt);
        }
        return listCat;
    }

    @Override
    public Catalog findById(Integer id)  {
        Catalog cat = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getCatalogById(?)}");
            callSt.setInt(1,id);
            ResultSet rs = callSt.executeQuery();
            cat =  new Catalog();
            if (rs.next()){
                cat.setCatalogId(rs.getInt("CatalogId"));
                cat.setCatalogName(rs.getString("CatalogName"));
                cat.setCatalogStatus(rs.getBoolean("CatalogStatus"));
            }
        }catch (SQLException ex1){
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return cat;
    }
    @Override
    public boolean save(Catalog catalog)  {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_insertCatalog(?,?)}");
            callSt.setString(1, catalog.getCatalogName());
            callSt.setBoolean(2, catalog.getCatalogStatus());
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
    public boolean update(Catalog catalog) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_updateCatalog(?,?,?)}");
            callSt.setInt(1,catalog.getCatalogId());
            callSt.setString(2,catalog.getCatalogName());
            callSt.setBoolean(3,catalog.getCatalogStatus());
            callSt.executeUpdate();
        }catch (SQLException ex1){
            result = false;
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt
            );
        }
        return result;
    }
    @Override
    public boolean delete(Integer id)  {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_UpdateCatalogStatus(?)}");
            callSt.setInt(1,id);
            callSt.executeUpdate();
        }catch (SQLException ex1){
            result = false;
            ex1.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return result;
    }
}