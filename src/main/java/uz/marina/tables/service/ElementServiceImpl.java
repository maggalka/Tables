package uz.marina.tables.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.marina.tables.dao.ElementDao;
import uz.marina.tables.model.Element;

import java.util.List;

/**
 * Created by Marina on 16.08.2017.
 */

@Service
@Transactional(readOnly = true)
public class ElementServiceImpl<T extends Element> implements ElementService {

    private ElementDao elementDao;

    public void setElementDao(ElementDao elementDao) {
        this.elementDao = elementDao;
    }

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
    public List<T> listElementsByColumnValue(String className, String columnName, int value) {
        return elementDao.listElementsByColumnValue(className,columnName,value);
    }

    @Override
    @Transactional
    public void removeElementsByColumnValue(String className, String columnName, int value) {
        elementDao.removeElementsByColumnValue(className,columnName,value);
    }

    @Override
    public List<T> listElements(String className, Long page) {
        return elementDao.listElements(className,page);
    }
}
