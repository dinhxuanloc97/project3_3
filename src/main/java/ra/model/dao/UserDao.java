package ra.model.dao;

import ra.model.entity.User;

import java.util.List;

public interface UserDao<T,V> extends IShop<T,V>{
    boolean register (User user);
    User login (String userName ,String pass);
    boolean unlockUser (Integer id);
    boolean lockUser (Integer  id);
    List<T> searchByName(String name);
}
