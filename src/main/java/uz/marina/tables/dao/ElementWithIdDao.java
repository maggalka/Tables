package uz.marina.tables.dao;

import uz.marina.tables.model.Element;
import uz.marina.tables.model.ElementWithId;

import java.util.List;

/**
 * Created by Vladimir on 14.08.2017.
 */
public interface ElementWithIdDao extends ElementDao  {
    Element getElementById(int id);
    List<ElementWithId> listElementsById(int id);
    void removeElementById(int id);
}
