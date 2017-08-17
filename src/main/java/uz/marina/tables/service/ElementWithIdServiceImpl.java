package uz.marina.tables.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import uz.marina.tables.dao.ElementWithIdDao;
import uz.marina.tables.model.Element;

/**
 * Created by Marina on 16.08.2017.
 */

@Transactional(readOnly = true)
public class ElementWithIdServiceImpl implements ElementWithIdService{

    @Autowired
    private ElementWithIdDao elementWithIdDao;

    @Override
    public Element getElementById(Class<? extends Element> elementClass, int id) {
        return elementWithIdDao.getElementById(elementClass,id);
    }

    @Transactional
    @Override
    public void removeElementById(Class<? extends Element> elementClass, int id) {
        elementWithIdDao.removeElementById(elementClass,id);
    }
}
