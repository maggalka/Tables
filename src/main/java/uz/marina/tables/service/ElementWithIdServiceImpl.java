package uz.marina.tables.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.marina.tables.dao.ElementWithIdDao;
import uz.marina.tables.model.ElementWithId;


/**
 * Created by Marina on 16.08.2017.
 */

@Service
@Transactional(readOnly = true)
public class ElementWithIdServiceImpl extends ElementServiceImpl implements ElementWithIdService{

    private ElementWithIdDao elementWithIdDao;

    public void setElementWithIdDao(ElementWithIdDao elementWithIdDao) {
        this.elementWithIdDao = elementWithIdDao;
    }

    @Override
    public ElementWithId getElementById(String className, int id) {
        return elementWithIdDao.getElementById(className,id);
    }

    @Transactional
    @Override
    public void removeElementById(String className, int id) {
        elementWithIdDao.removeElementById(className,id);
    }

}
