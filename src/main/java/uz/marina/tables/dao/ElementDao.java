package uz.marina.tables.dao;

import uz.marina.tables.model.Element;

import java.util.List;

/**
 * Created by Marina on 15.08.2017.
 */
public interface ElementDao<T extends Element> {
    void addElement(Element element);
    void updateElement(Element element);

    List<T> listElementsByColumnValue(String className, String columnName, int value);
    void removeElementsByColumnValue(String className, String columnName, int value);

    List <T> listElements(String className, Long page);
}
