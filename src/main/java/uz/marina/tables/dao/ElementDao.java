package uz.marina.tables.dao;

import uz.marina.tables.model.Element;

import java.util.List;

/**
 * Created by Marina on 15.08.2017.
 */
public interface ElementDao {
    void addElement(Element element);
    void updateElement(Element element);

    List<Element> listElementsByColumnValue(Class<? extends Element> elementClass, String columnName, int value);
    void removeElementsByColumnValue(Class<? extends Element> elementClass, String columnName, int value);

    List<Element> listElements(String className, Long page);
}
