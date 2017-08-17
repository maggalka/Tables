package uz.marina.tables.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;
import uz.marina.tables.model.Element;

/**
 * Created by Marina on 16.08.2017.
 */

@Repository
public class ElementWithIdDaoImpl extends ElementDaoImpl implements ElementWithIdDao {
    private static final Logger logger = LoggerFactory.logger(ElementDaoImpl.class);

    @Override
    public Element getElementById(Class<? extends Element> elementClass, int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Element element = (Element) session.get(elementClass,new Integer(id));
        logger.info(element.getClass().getSimpleName()+" successfully saved. Details:"+element);
        return element;
    }

    @Override
    public void removeElementById(Class<? extends Element> elementClass, int id) {
        Session session = this.sessionFactory.getCurrentSession();
        String tableName = elementClass.getSimpleName().toLowerCase();
        Query query = session.createQuery("delete from "+tableName+" where "+tableName+".id = :id");
        query.setParameter("id",id);
        logger.info("Deleted from "+tableName+" where id="+id);
    }
}
