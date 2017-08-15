package uz.marina.tables.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;
import uz.marina.tables.model.User;

import org.hibernate.Query;
import java.util.List;

/**
 * Created by Vladimir on 06.03.2017.
 */

@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.logger(UserDaoImpl.class);

    private SessionFactory sessionFactory;
    private static final int limitResultsPerPage = 10;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User successfully saved. User details:" + user);
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User successfully updated. User details:" + user);
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();

        User user = (User) session.load(User.class, new Integer(id));
        if (user!=null)
            session.delete(user);
        logger.info("User successfully removed. User details:" + user);
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        logger.info("User successfully loaded. User details:" + user);
        return user;
    }

    // Получаем из БД лист юзеров, которые должны содержаться на странице page
    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers(Long page) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User");
        query.setFirstResult((int)(page-1)*limitResultsPerPage);
        query.setMaxResults(limitResultsPerPage);
        List<User> userList = query.list();

        for (User user : userList)
            logger.info("User list:"+user);
        return userList;
    }

    // Получаем из БД лист юзеров с нужным именем
    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsersByName(String userName) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User user where user.name = :userName ");
        query.setParameter("userName",userName);
        System.out.println(userName);
        List<User> userList = query.list();
        for (User user : userList)
            logger.info("User search list:"+user);
        return userList;
    }
}
