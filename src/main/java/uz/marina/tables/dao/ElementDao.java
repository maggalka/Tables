package uz.marina.tables.dao;

import uz.marina.tables.model.Element;

import java.util.List;

/**
 * Created by Vladimir on 14.08.2017.
 */
public interface ElementDao {
    void addElement(Element element);
    void updateElement(Element element);

    List<Element> listElementsByColumnValue(String columnName, int value);
    void removeElementsByColumnValue(String columnName, int value);

    List<Element> listElements(Long page);
}
