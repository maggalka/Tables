package uz.marina.tables.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;
import uz.marina.tables.model.ElementWithId;

/**
 * Created by Marina on 16.08.2017.
 */

@Repository
public class ElementWithIdDaoImpl extends ElementDaoImpl implements ElementWithIdDao {
    private static final Logger logger = LoggerFactory.logger(ElementDaoImpl.class);

    @Override
    public ElementWithId getElementById(String className, int id) {
        Session session = this.sessionFactory.getCurrentSession();
        ElementWithId element=null;
        try {
            element = (ElementWithId) session.get(Class.forName(className), new Integer(id));
        }
        catch (ClassNotFoundException e){
            logger.error("Get element by id query failure. Class for classname="+className+" not found.");
        }
        logger.info(className+" successfully saved. Details:"+element);
        return element;
    }

    @Override
    public void removeElementById(String className, int id) {
        Session session = this.sessionFactory.getCurrentSession();
        String tableName = className.toLowerCase();
        Query query = session.createQuery("delete from "+tableName+" where "+tableName+".id = :id");
        query.setParameter("id",id);
        logger.info("Deleted from "+tableName+" where id="+id);
    }
}
