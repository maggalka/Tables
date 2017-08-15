package uz.marina.tables.service;

import uz.marina.tables.model.User;

import java.util.List;

/**
 * Created by Vladimir on 06.03.2017.
 */
public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void removeUser(int id);
    User getUserById(int id);
    List<User> listUsers(Long page);
    List<User> listUsersByName(String name);
}
