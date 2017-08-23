package uz.marina.tables.dao;

import uz.marina.tables.model.Element;
import uz.marina.tables.model.ElementWithId;

import java.util.List;

/**
 * Created by Marina on 15.08.2017.
 */
public interface ElementWithIdDao<T extends Element> extends ElementDao<T>  {
    ElementWithId getElementById(String className, int id);
    void removeElementById(String className, int id);
}
