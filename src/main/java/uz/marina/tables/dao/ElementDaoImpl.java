package uz.marina.tables.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;
import uz.marina.tables.model.Element;
import uz.marina.tables.model.User;

import org.hibernate.Query;
import java.util.List;

/**
 * Created by Vladimir on 06.03.2017.
 */

@Repository
public class ElementDaoImpl implements ElementDao {
    private static final Logger logger = LoggerFactory.logger(ElementDaoImpl.class);

    private SessionFactory sessionFactory;
    private static final int limitResultsPerPage = 10;

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addElement(Element element) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(element);
        logger.info(element.getClass().getSimpleName()+" successfully saved. Details:"+element);
    }

    @Override
    public void updateElement(Element element) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(element);
        logger.info(element.getClass().getSimpleName()+" successfully updated. Details:"+element);
    }

    @Override
    public List<Element> listElementsByColumnValue(String columnName, int value) {
        return null;
    }

    @Override
    public void removeElementsByColumnValue(String columnName, int value) {

    }

    @Override
    public List<Element> listElements(Long page) {
        return null;
    }
}
