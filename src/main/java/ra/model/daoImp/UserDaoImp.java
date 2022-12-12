package ra.model.daoImp;

import ra.model.dao.UserDao;
import ra.model.entity.Product;
import ra.model.entity.User;
import ra.model.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {
    @Override
    public boolean register(User user) {
        Connection conn = null;
        CallableStatement calSt = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            calSt = conn.prepareCall("{call proc_register(?,?,?,?)}");
            calSt.setString(1,user.getUserName());
            calSt.setString(2,user.getPassword());
            calSt.setString(3,user.getPhoneNumber());
            calSt.setString(4,user.getFullName());
            calSt.executeUpdate();
        }catch (Exception e){
            result = false;
            e.printStackTrace();
        }
        finally {
            ConnectionDB.closeConnection(conn,calSt);
        }
        return result;
    }

    @Override
    public User login(String userName, String pass) {
        Connection conn = null;
        CallableStatement calSt = null;
        User user= null;
        try {
            conn = ConnectionDB.openConnection();
            calSt = conn.prepareCall("{call proc_login(?,?)}");
            calSt.setString(1,userName);
            calSt.setString(2,pass);
            ResultSet rs = calSt.executeQuery();
            user = new User();
            if (rs.next()){
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setPermisson(rs.getBoolean("permisson"));
                user.setUserStatus(rs.getBoolean("userStatus"));
                user.setFullName(rs.getString("fullName"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,calSt);
        }
        return user;
    }

    @Override
    public boolean unlockUser(Integer id) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_UnlockUser(?)}");
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
    @Override
    public boolean lockUser(Integer id) {
        boolean result = true;
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_lockUser(?)}");
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

    @Override
    public List searchByName(String name) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<User> listUser = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_searchUserName(?)}");
            listUser = new ArrayList<>();
            callSt.setString(1,name);
            ResultSet rs = callSt.executeQuery();
            listUser = new ArrayList<>();
            while (rs.next()) {
                User us = new User();
                us.setUserId(rs.getInt("userId"));
                us.setUserName(rs.getString("userName"));
                us.setFullName(rs.getString("fullName"));
                us.setPassword(rs.getString("password"));
                us.setUserStatus(rs.getBoolean("userStatus"));
                us.setEmail(rs.getString("email"));
                us.setPhoneNumber(rs.getString("phoneNumber"));
                listUser.add(us);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listUser;
    }

    @Override
    public List<User> findAll() {
        List<User> listUser = null;
        Connection conn = null;
        CallableStatement callSt = null;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call proc_getAllUser()}");
            ResultSet rs = callSt.executeQuery();
            listUser = new ArrayList<>();
            while (rs.next()){
                User us = new User();
                us.setUserId(rs.getInt("userId"));
                us.setUserName(rs.getString("userName"));
                us.setFullName(rs.getString("fullName"));
                us.setPassword(rs.getString("password"));
                us.setUserStatus(rs.getBoolean("userStatus"));
                us.setEmail(rs.getString("email"));
                us.setPhoneNumber(rs.getString("phoneNumber"));
                listUser.add(us);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return listUser ;
    }

    @Override
    public Object findById(Object id) {
        return null;
    }
    @Override
    public boolean save(Object o) {
        return false;
    }

    @Override
    public boolean update(Object o) {
        return false;
    }

    @Override
    public boolean delete(Object id) {
        return false;
    }
}