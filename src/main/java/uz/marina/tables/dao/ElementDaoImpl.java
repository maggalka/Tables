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
 * Created by Marina on 16.08.2017.
 */

@Repository
public class ElementDaoImpl implements ElementDao {
    private static final Logger logger = LoggerFactory.logger(ElementDaoImpl.class);

    protected SessionFactory sessionFactory;
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
    public List<Element> listElementsByColumnValue(Class<? extends Element> elementClass, String columnName, int value) {
        Session session = this.sessionFactory.getCurrentSession();
        String tableName = elementClass.getSimpleName().toLowerCase();
        Query query = session.createQuery("from "+tableName+" where "+tableName+"."+columnName+" = :value");
        query.setParameter("value",value);
        List<Element> elementList = query.list();
        for (Element element : elementList)
            logger.info(element.getClass().getSimpleName()+"search list:"+element);
        return elementList;
    }

    @Override
    public void removeElementsByColumnValue(Class<? extends Element> elementClass, String columnName, int value) {
        Session session = this.sessionFactory.getCurrentSession();
        String tableName = elementClass.getSimpleName().toLowerCase();
        Query query = session.createQuery("delete from "+tableName+" where "+tableName+"."+columnName+" = :value");
        query.setParameter("value",value);
        int rowsDeleted = query.executeUpdate();
        logger.info("Deleted "+rowsDeleted+" rows from "+tableName+" with "+columnName+"="+value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Element> listElements(String className, Long page) {
        Session session = this.sessionFactory.getCurrentSession();
        String tableName = className.toLowerCase();
        Query query = session.createQuery("from "+tableName);
        query.setFirstResult((int)(page-1)*limitResultsPerPage);
        query.setMaxResults(limitResultsPerPage);
        List<Element> elementList = query.list();
        for (Element element : elementList)
            logger.info(element.getClass().getSimpleName()+"search list:"+element);
        return elementList;
    }
}
