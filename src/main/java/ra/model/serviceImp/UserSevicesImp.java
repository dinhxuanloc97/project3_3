package ra.model.serviceImp;

import ra.model.dao.UserDao;
import ra.model.daoImp.UserDaoImp;
import ra.model.entity.User;
import ra.model.service.UserServices;

import java.util.List;

public class UserSevicesImp implements UserServices<User,String> {
    private UserDao<User, Integer> userDao = new UserDaoImp();

    @Override
    public boolean register(User user) {
        return userDao.register(user);
    }

    @Override
    public User login(String userName, String pass) {
        return userDao.login(userName, pass);
    }

    @Override
    public boolean unlockUser(Integer id) {
         return userDao.unlockUser(id);
    }

    @Override
    public boolean lockUser(Integer id) {
        return userDao.lockUser(id);
    }

    @Override
    public List<User> searchByName(String name) {
        return userDao.searchByName(name);
    }
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public boolean save(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}