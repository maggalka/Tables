package uz.marina.tables.dao;

import uz.marina.tables.model.Element;
import uz.marina.tables.model.ElementWithId;

import java.util.List;

/**
 * Created by Marina on 15.08.2017.
 */
public interface ElementWithIdDao extends ElementDao  {
    Element getElementById(Class<? extends Element> elementClass, int id);
    void removeElementById(Class<? extends Element> elementClass, int id);
}
