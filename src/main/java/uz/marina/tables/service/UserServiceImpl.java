package uz.marina.tables.service;

import org.springframework.stereotype.Service;
import uz.marina.tables.dao.UserDao;
import uz.marina.tables.model.User;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Vladimir on 06.03.2017.
 */

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> listUsers(Long page) {
        return this.userDao.listUsers(page);
    }

    @Override
    @Transactional
    public List<User> listUsersByName(String name) {
        return this.userDao.listUsersByName(name);
    }
}
