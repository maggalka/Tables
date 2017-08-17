package uz.marina.tables.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import uz.marina.tables.dao.ElementDao;
import uz.marina.tables.model.Element;

import java.util.List;

/**
 * Created by Marina on 16.08.2017.
 */
@Transactional(readOnly = true)
public class ElementServiceImpl implements ElementService {

    @Autowired
    private ElementDao elementDao;

    @Override
    @Transactional
    public void addElement(Element element) {
        elementDao.addElement(element);
    }

    @Override
    @Transactional
    public void updateElement(Element element) {
        elementDao.updateElement(element);
    }

    @Override
    public List<Element> listElementsByColumnValue(Class<? extends Element> elementClass, String columnName, int value) {
        return elementDao.listElementsByColumnValue(elementClass,columnName,value);
    }

    @Override
    @Transactional
    public void removeElementsByColumnValue(Class<? extends Element> elementClass, String columnName, int value) {
        elementDao.removeElementsByColumnValue(elementClass,columnName,value);
    }

    @Override
    public List<Element> listElements(String className, Long page) {
        return elementDao.listElements(className,page);
    }
}
